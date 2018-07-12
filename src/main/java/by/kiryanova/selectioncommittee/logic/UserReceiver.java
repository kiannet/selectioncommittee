package by.kiryanova.selectioncommittee.logic;

import by.kiryanova.selectioncommittee.dao.impl.UniversityDAO;
import by.kiryanova.selectioncommittee.dao.impl.UserDAO;
import by.kiryanova.selectioncommittee.entity.Enrollee;
import by.kiryanova.selectioncommittee.entity.User;
import by.kiryanova.selectioncommittee.exception.DAOException;


public class UserReceiver {
    UserDAO dao = UserDAO.getInstance();
    UniversityDAO universityDAO = UniversityDAO.getInstance();

    public void deleteUserByUserId(int userId){
        try {
            dao.deleteUserByUserId(userId);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public User checkUser(String login, String password) {
        User user = null;
        try {
            user = dao.findUserByUsernameAndPassword(login, password);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return user;
    }

    public Enrollee findEnrollee(String username){
        Enrollee enrollee = new Enrollee();
        try {
            enrollee = dao.findEnrolleeByUsername(username);
            dao.addSpecialtyForEnrollee(enrollee);
            universityDAO.addSubjectNamesForEnrollee(enrollee);
            universityDAO.addPointsForEnrollee(enrollee);
            universityDAO.findEnrolleesCertificate(enrollee);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return enrollee;
    }

    public void addUser(String username, String password, String email,
                        String surname, String name, String secondName, String passportID, String phone,
                        String firstSubjectName, String secondSubjectName, String thirdSubjectName,
                        String firstSubjectPoints, String secondSubjectPoints, String thirdSubjectPoints,
                        String certificate, String specialty){
        int point1 = Integer.parseInt(firstSubjectPoints);
        int points2 =  Integer.parseInt(secondSubjectPoints);
        int point3 = Integer.parseInt(thirdSubjectPoints);

        try {
            dao.addEnrollee(passportID, surname, name, secondName, phone, Integer.parseInt(certificate), null);
            dao.addUser(email, password, username);
            int enrolleeId = dao.findEnrolleeIdByPassport(passportID);
            dao.addEnrolleeIdToUser(enrolleeId, username);
            dao.addEnrolleeIdToSubjects(firstSubjectName, point1, enrolleeId);
            dao.addEnrolleeIdToSubjects(secondSubjectName, points2, enrolleeId);
            dao.addEnrolleeIdToSubjects(thirdSubjectName, point3, enrolleeId);
            dao.addEnrolleeIdToSpecalty(enrolleeId, specialty);
    } catch (DAOException e) {
        e.printStackTrace();
    }
    }


}
