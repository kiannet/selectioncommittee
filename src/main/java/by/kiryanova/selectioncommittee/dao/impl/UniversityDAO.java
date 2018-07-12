package by.kiryanova.selectioncommittee.dao.impl;

import by.kiryanova.selectioncommittee.connectionpool.ConnectionPool;
import by.kiryanova.selectioncommittee.connectionpool.ProxyConnection;
import by.kiryanova.selectioncommittee.dao.IUniversityDAO;
import by.kiryanova.selectioncommittee.entity.Enrollee;
import by.kiryanova.selectioncommittee.entity.Faculty;
import by.kiryanova.selectioncommittee.exception.ConnectionException;
import by.kiryanova.selectioncommittee.exception.DAOException;


import javax.print.DocFlavor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;

public class UniversityDAO {
    private static final String SELECT_FACULTIES_BY_UNIVERSITY = "SELECT name FROM faculty WHERE university_id = (SELECT university_id FROM university WHERE name = ?);";
    private static final String SELECT_SPECIALITIES_BY_FACULTY = "SELECT name FROM specialty WHERE faculty_id = (SELECT faculty_id FROM faculty WHERE name = ?);";
    private static final String SELECT_SPECIALITIES = "SELECT s.name, f.name FROM specialty s JOIN Faculty f ON f.faculty_id = s.faculty_id;";
    private static final String SELECT_SUBJECTS = "SELECT name FROM subject";
    private static final String SELECT_SPECIALTIES_BY_FACULTY_ID = "SELECT name FROM specialty WHERE faculty_id=?";
    private static final String SELECT_ENROLLEES_BY_SPECIALTY = "SELECT surname, name, second_name FROM enrollee WHERE enrollee_id IN (SELECT enrollee_id FROM enrollee_specialty WHERE specialty_id=(SELECT specialty_id FROM specialty WHERE name = ?))";
    private static final String SELECT_POINTS_BY_EBROLLEE_ID = "SELECT points FROM enrollee_subject_points WHERE enrollee_id=?";
    private static final String SELECT_CERTIFICATE_BY_ENROLLEE_ID = "SELECT certificate FROM enrollee WHERE enrollee_id=?";
    private static final String SELECT_SUBJECT_NAMES_BY_EBROLLEE_ID = "SELECT name FROM subject JOIN enrollee_subject_points ON (subject_id = subject_id_p) WHERE enrollee_id=?";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String SECOND_NAME = "second_name";
    private static final String POINTS = "points";

    private static final UniversityDAO INSTANCE;
    private static AtomicBoolean instanceCreated = new AtomicBoolean(false);

    static {
        INSTANCE = new UniversityDAO();
        instanceCreated.set(true);
    }

    private UniversityDAO() {
        if (instanceCreated.get()) {
            //LOGGER
            throw new RuntimeException("Tried to create singleton object with reflection api");
        }
    }

    public static UniversityDAO getInstance() {
        return INSTANCE;
    }

    public Map<String, List<String>> findSpecialties() throws DAOException {
        Map<String, List<String>> specialtiesByFaculty = new HashMap<>();

        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_SPECIALITIES)) {
            //statement.setString(1, specialty);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String faculty = resultSet.getString("f.name");
                String specialty = resultSet.getString("s.name");

                if (specialtiesByFaculty.containsKey(faculty)) {
                    specialtiesByFaculty.get(faculty).add(specialty);
                } else {
                    List<String> specialties = new ArrayList<>();
                    specialties.add(specialty);
                    specialtiesByFaculty.put(faculty, specialties);
                }

            }
            return specialtiesByFaculty;
        } catch (SQLException e) {
            throw new DAOException(e);
        }


    }

    public void findEnrolleesCertificate(Enrollee enrollee) throws DAOException {
        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_CERTIFICATE_BY_ENROLLEE_ID)) {
            statement.setInt(1, enrollee.getEnrolleeId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int certificate = resultSet.getInt("certificate");
                enrollee.setCertificate(certificate);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public List<Enrollee> findEnrolleesBySpecialty(String specialty) throws DAOException {
        List<Enrollee> enrollees = new ArrayList<>();

        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ENROLLEES_BY_SPECIALTY)) {
            statement.setString(1, specialty);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String surname = resultSet.getString(SURNAME);
                String name = resultSet.getString(NAME);
                String secondName = resultSet.getString(SECOND_NAME);
                Enrollee enrollee = new Enrollee();
                enrollee.setSurname(surname);
                enrollee.setName(name);
                enrollee.setSecondName(secondName);
                enrollees.add(enrollee);
            }
            return enrollees;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public void addSubjectNamesForEnrollee(Enrollee enrollee) throws DAOException {
        List<String> subjects = new ArrayList<>();

        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_SUBJECT_NAMES_BY_EBROLLEE_ID)) {
            statement.setInt(1, enrollee.getEnrolleeId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String subject = resultSet.getString("name");
                subjects.add(subject);
            }
            enrollee.setSubjectNames(subjects);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public void addPointsForEnrollee(Enrollee enrollee) throws DAOException {
        List<Integer> points = new ArrayList<>();

        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_POINTS_BY_EBROLLEE_ID)) {
            statement.setInt(1, enrollee.getEnrolleeId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int point = resultSet.getInt(POINTS);
                points.add(point);
            }
            enrollee.setPoints(points);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public List<String> findSubjects() throws DAOException {
        List<String> faculties = new ArrayList<>();

        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_SUBJECTS)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String faculty = resultSet.getString(NAME);
                faculties.add(faculty);
            }
            return faculties;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public List<String> findFaculties(String universityName) throws DAOException {
        List<String> faculties = new ArrayList<>();

        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_FACULTIES_BY_UNIVERSITY)) {
            statement.setString(1, universityName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String faculty = resultSet.getString(NAME);
                faculties.add(faculty);
            }
            return faculties;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }


    public List<String> findSpecialities(String facultyName) throws DAOException {
        List<String> specialities = new ArrayList<>();

        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_SPECIALITIES_BY_FACULTY)) {
            statement.setString(1, facultyName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String faculty = resultSet.getString(NAME);
                specialities.add(faculty);
            }
            return specialities;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public List<String> findSpecialitiesByFacultyID(String facultyId) throws DAOException {
        List<String> specialities = new ArrayList<>();

        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_SPECIALTIES_BY_FACULTY_ID)) {

            statement.setInt(1, Integer.parseInt(facultyId));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String specialty = resultSet.getString(NAME);
                specialities.add(specialty);
            }
            return specialities;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
