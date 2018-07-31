package by.kiryanova.selectioncommittee.service;

import by.kiryanova.selectioncommittee.dao.impl.UniversityDAO;
import by.kiryanova.selectioncommittee.dao.impl.UserDAO;
import by.kiryanova.selectioncommittee.entity.Enrollee;
import by.kiryanova.selectioncommittee.entity.User;
import by.kiryanova.selectioncommittee.exception.DAOException;
import by.kiryanova.selectioncommittee.exception.ServiceException;
import by.kiryanova.selectioncommittee.validator.Validator;


public class UserService {
    UserDAO dao = UserDAO.getInstance();
    UniversityDAO universityDAO = UniversityDAO.getInstance();

    public void deleteUserByUserId(int userId) throws ServiceException {
        try {
            dao.deleteUserByUserId(userId);
        } catch (DAOException e) {
            throw new ServiceException(e);
            //e.printStackTrace();
        }
    }

    public User checkUser(String login, String password) throws ServiceException {
        User user = null;
        try {
            user = dao.findUserByUsernameAndPassword(login, password);
        } catch (DAOException e) {
            throw new ServiceException(e);
            //e.printStackTrace();
        }
        return user;
    }

    public Enrollee findEnrollee(String username) throws ServiceException {
        Enrollee enrollee = new Enrollee();
        try {
            enrollee = dao.findEnrolleeByUsername(username);
            dao.addSpecialtyForEnrollee(enrollee);
            universityDAO.addSubjectNamesForEnrollee(enrollee);
            universityDAO.addPointsForEnrollee(enrollee);
            universityDAO.findEnrolleesCertificate(enrollee);
        } catch (DAOException e) {
            throw new ServiceException(e);
            //e.printStackTrace();
        }
        return enrollee;
    }

    public boolean addUser(String username, String password, String email,
                        String surname, String name, String secondName, String passportID, String phone,
                        String firstSubjectName, String secondSubjectName, String thirdSubjectName,
                        String firstSubjectPoints, String secondSubjectPoints, String thirdSubjectPoints,
                        String certificate, String specialty) throws ServiceException {

        int point1 = Integer.parseInt(firstSubjectPoints);
        int points2 =  Integer.parseInt(secondSubjectPoints);
        int point3 = Integer.parseInt(thirdSubjectPoints);

        if (Validator.validateSigningUp(surname, name, secondName, email, username, password, passportID, phone, firstSubjectPoints, secondSubjectPoints, thirdSubjectPoints, certificate)) {
            try {
                dao.addEnrollee(passportID, surname, name, secondName, phone, Integer.parseInt(certificate), null);
                dao.addUser(email, password, username);
                int enrolleeId = dao.findEnrolleeIdByPassport(passportID);
                dao.addEnrolleeIdToUser(enrolleeId, username);
                dao.addEnrolleeIdToSubjects(firstSubjectName, point1, enrolleeId);
                dao.addEnrolleeIdToSubjects(secondSubjectName, points2, enrolleeId);
                dao.addEnrolleeIdToSubjects(thirdSubjectName, point3, enrolleeId);
                dao.addEnrolleeIdToSpecalty(enrolleeId, specialty);

                return true;
            } catch (DAOException e) {
                throw new ServiceException(e);
            }
        }
        else {
            return false;
        }

    }

    public void addEnrollee(String surname, String name, String secondName, String passportID, String phone,
                            String firstSubjectName, String secondSubjectName, String thirdSubjectName,
                            String firstSubjectPoints, String secondSubjectPoints, String thirdSubjectPoints,
                            String certificate, String specialty){

        try {
            int enrolleeId = dao.findEnrolleeIdByPassport(passportID);
            dao.addEnrollee(passportID, surname, name, secondName, phone, Integer.parseInt(certificate), null);
            dao.addEnrolleeIdToSubjects(firstSubjectName, Integer.parseInt(firstSubjectPoints), enrolleeId);
            dao.addEnrolleeIdToSubjects(secondSubjectName, Integer.parseInt(secondSubjectPoints), enrolleeId);
            dao.addEnrolleeIdToSubjects(thirdSubjectName, Integer.parseInt(thirdSubjectPoints), enrolleeId);
            dao.addEnrolleeIdToSpecalty(enrolleeId, specialty);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }


    public void updateEnrolleeInfo(String surname, String name, String secondName, String passportID, String phone, int userID) throws ServiceException {
        try {
            int enrolleeId = dao.findEnrolleeIdByUserId(userID);
            dao.updateEnrolleeInfo(surname, name, secondName, passportID, phone, enrolleeId);
        } catch (DAOException e) {
            throw new ServiceException(e);
            //e.printStackTrace();
        }
    }

    public void updatePassword(String password, int userID) throws ServiceException {
        try {
            dao.updatePasswordByUserId(password, userID);
        } catch (DAOException e) {
            throw new ServiceException(e);
            //e.printStackTrace();
        }
    }

}
