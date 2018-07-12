package by.kiryanova.selectioncommittee.logic;

import by.kiryanova.selectioncommittee.dao.IUniversityDAO;
import by.kiryanova.selectioncommittee.dao.IUserDAO;
import by.kiryanova.selectioncommittee.dao.impl.UniversityDAO;
import by.kiryanova.selectioncommittee.dao.impl.UserDAO;
import by.kiryanova.selectioncommittee.entity.Enrollee;
import by.kiryanova.selectioncommittee.entity.Faculty;
import by.kiryanova.selectioncommittee.entity.University;
import by.kiryanova.selectioncommittee.exception.ConnectionException;
import by.kiryanova.selectioncommittee.exception.DAOException;
import by.kiryanova.selectioncommittee.exception.RecieverException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniversityReceiver {

    public Map<String, List<String>> findSpecialties(){
        UniversityDAO dao = UniversityDAO.getInstance();
        Map<String, List<String>> specialties = new HashMap<>();

        try {
            specialties = dao.findSpecialties();
        } catch (DAOException e) {
            e.printStackTrace();
        }

        return specialties;
    }

    public List<Enrollee> findEnrollees(String specialty){
        UniversityDAO dao = UniversityDAO.getInstance();
        List<Enrollee> enrollees = new ArrayList<>();

        try {
            enrollees = dao.findEnrolleesBySpecialty(specialty);
        } catch (DAOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < enrollees.size(); i++){
            try {
                dao.addPointsForEnrollee(enrollees.get(i));//////////????????
                dao.findEnrolleesCertificate(enrollees.get(i));
                dao.addSubjectNamesForEnrollee(enrollees.get(i));
            } catch (DAOException e) {
                e.printStackTrace();
            }
        }

        return enrollees;
    }

    public List<String> findFacultiesNames(String name)  {
        List<String> faculties = new ArrayList<>();

        UniversityDAO dao = UniversityDAO.getInstance();

        try {
            faculties = dao.findFaculties(name);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return faculties;
    }

    public List<String> findSubjectsNames(){
        List<String> subjects = new ArrayList<>();

        UniversityDAO dao = UniversityDAO.getInstance();

        try {
            subjects = dao.findSubjects();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return subjects;
    }

    public List<String> findSpecialitiesNames(String name){
        List<String> specialities = new ArrayList<>();

        UniversityDAO dao = UniversityDAO.getInstance();

        try {
            specialities = dao.findSpecialities(name);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return specialities;
    }

    public List<String> findSpecialitiesNamesByFacultyId(String facultyId){
        List<String> specialities = new ArrayList<>();

        UniversityDAO dao = UniversityDAO.getInstance();

        try {
            specialities = dao.findSpecialitiesByFacultyID(facultyId);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return specialities;
    }

}
