package by.kiryanova.selectioncommittee.dao.impl;

import by.kiryanova.selectioncommittee.pool.ConnectionPool;
import by.kiryanova.selectioncommittee.pool.ProxyConnection;
import by.kiryanova.selectioncommittee.entity.Enrollee;
import by.kiryanova.selectioncommittee.entity.User;
import by.kiryanova.selectioncommittee.exception.DAOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class UserDAO  {

    private static final String SELECT_USER_ID_BY_USERNAME_PASSWORD = "SELECT user_id FROM user WHERE username=? AND password=?";
    private static final String INSERT_INTO_ENROLLEE = "INSERT INTO enrollee(passport_id, surname, name, second_name, phone, certificate) VALUES (?,?,?,?,?,?)";
    private static final String INSERT_INTO_USERS = "INSERT INTO users(email, password, type, username, ban) VALUES (?,?,?,?,?)";
    private static final String INSERT_INTO_ENROLLEE_SUBJECT_POINTS = "INSERT INTO enrollee_subject_points(subject_id_p, points, enrollee_id) VALUES ((SELECT subject_id FROM subject WHERE name=?), ?, ?)";
    private static final String INSERT_INTO_ENROLLEE_SPECIALTY = "INSERT INTO enrollee_specialty(enrollee_id, specialty_id) VALUES (?, (SELECT specialty_id FROM specialty WHERE name=?))";
    private static final String SELECT_ENROLLEE_ID_BY_PASSPORT = "SELECT enrollee_id FROM enrollee WHERE passport_id=?";
    private static final String INSERT_ENROLLEE_ID_IN_USERS = "INSERT INTO users(enrollee_id) VALUES enrollee_id=? WHERE username=?";

    private static final String SET_ENROLLEE_ID_IN_USERS = "UPDATE users SET enrollee_id=? WHERE username=?";
    private static final String SELECT_USER_BY_USERANME_AND_PASSWORD = "SELECT user_id, email, password, type, username, enrollee_id, ban FROM users WHERE username=? AND PASSWORD=?";
    private static final String SELECT_ENROLLEE_BY_USERNAME = "SELECT enrollee_id, passport_id, surname, name, second_name, phone, certificate FROM enrollee WHERE enrollee_id = (SELECT enrollee_id FROM users WHERE username=?)";
    private static final String SELECT_SPECIALTY_BY_ENROLLEE_ID = "SELECT name FROM specialty WHERE specialty_id = (SELECT specialty_id FROM enrollee_specialty WHERE enrollee_id=?)";
    private static final String DELETE_USER = "DELETE FROM users WHERE user_id = ?";
    private static final String UPDATE_ENROLLEE_INFO = "UPDATE enrollee SET surname=?, name=?, second_name=?, passport_id=?, phone=? WHERE enrollee_id=?";
    private static final String FIND_ENROLLEE_ID_BY_USER_ID = "SELECT enrollee_id FROM users WHERE user_id=?";
    private static final String UPDATE_PASSWORD_BY_USER_ID = "UPDATE users SET password=? WHERE user_id=?";
    private static final String SELECT_USER = "SELECT user_id, email, password, username, ban FROM users WHERE type='user'";
    private static final String USER = "user";

    private static final UserDAO INSTANCE;
    private static AtomicBoolean instanceCreated = new AtomicBoolean(false);

    static {
        INSTANCE = new UserDAO();
        instanceCreated.set(true);
    }

    private UserDAO(){
        if (instanceCreated.get()) {
            //LOGGER.log(Level.FATAL, "Tried to create singleton object with reflection api");
            throw new RuntimeException("Tried to create singleton object with reflection api");
        }
    }

    public static UserDAO getInstance() {
        return INSTANCE;
    }

    public void addSpecialtyForEnrollee(Enrollee enrollee) throws DAOException {

        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_SPECIALTY_BY_ENROLLEE_ID)) {
            statement.setInt(1, enrollee.getEnrolleeId());

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                enrollee.setSpecialty(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

    }

    public void deleteUserByUserId(int userId) throws DAOException {
        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USER)) {
            statement.setInt(1, userId);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    public Enrollee findEnrolleeByUsername(String username) throws DAOException {
        Enrollee enrollee = new Enrollee();

        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ENROLLEE_BY_USERNAME)) {
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                enrollee.setEnrolleeId(resultSet.getInt("enrollee_id"));
                enrollee.setPassportId(resultSet.getString("passport_id"));
                enrollee.setSurname(resultSet.getString("surname"));
                enrollee.setName(resultSet.getString("name"));
                enrollee.setSecondName(resultSet.getString("second_name"));
                enrollee.setPhone(resultSet.getString("phone"));
                enrollee.setCertificate(resultSet.getInt("certificate"));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return enrollee;
    }

    public User findUserByUsernameAndPassword(String username, String password) throws DAOException {
        User user = null;

        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_USERANME_AND_PASSWORD)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setUserId(resultSet.getInt("user_id"));
                user.setEmail(resultSet.getString("email"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("type"));
                user.setBan(resultSet.getString("ban"));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return user;
    }


    public boolean addEnrollee(String passportId, String surname, String name, String secondName, String phone, int certificate, String pic) throws DAOException {

        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_INTO_ENROLLEE)) {
            statement.setString(1, passportId);
            statement.setString(2, surname);
            statement.setString(3, name);
            statement.setString(4, secondName);
            statement.setString(5, phone);
            statement.setInt(6, certificate);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return true;
    }



    public boolean addUser(String email, String password, String login) throws DAOException {
        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_INTO_USERS)) {
            statement.setString(1, email);
            statement.setString(2, password);
            statement.setString(3, USER);
            statement.setString(4, login);
            statement.setString(5, "false");

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return true;
    }

    public boolean addEnrolleeIdToUser(int enrolleeId, String username) throws DAOException {
        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SET_ENROLLEE_ID_IN_USERS)) {
            statement.setInt(1, enrolleeId);
            statement.setString(2, username);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return true;
    }

    public boolean addEnrolleeIdToSpecalty(int enrolleeId, String specialty) throws DAOException {
        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_INTO_ENROLLEE_SPECIALTY)) {
            statement.setInt(1, enrolleeId);
            statement.setString(2, specialty);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return true;
    }

    public boolean addEnrolleeIdToSubjects(String subject, int points, int enrolleeId) throws DAOException {
        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_INTO_ENROLLEE_SUBJECT_POINTS)) {
            statement.setString(1, subject);
            statement.setInt(2, points);
            statement.setInt(3, enrolleeId);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return true;
    }

    public int findEnrolleeIdByPassport(String passportId) throws DAOException {
        int enrolleeId = 0;

        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ENROLLEE_ID_BY_PASSPORT)) {
            statement.setString(1, passportId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                enrolleeId = resultSet.getInt("enrollee_id");
            }
            return enrolleeId;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public int findEnrolleeIdByUserId(int userId) throws DAOException {
        int enrolleeId = 0;

        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ENROLLEE_ID_BY_USER_ID)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                enrolleeId = resultSet.getInt("enrollee_id");
            }
            return enrolleeId;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }


    public void updateEnrolleeInfo(String surname, String name, String secondName, String passportId, String phone, int enrolleeID) throws DAOException {
        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ENROLLEE_INFO)) {
            statement.setString(1, surname);
            statement.setString(2, name);
            statement.setString(3, secondName);
            statement.setString(4, passportId);
            statement.setString(5, phone);
            statement.setInt(6, enrolleeID);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public void updatePasswordByUserId(String password, int userId) throws DAOException{
        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PASSWORD_BY_USER_ID)) {
            statement.setString(1, password);
            statement.setInt(2, userId);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public List<User> findAllUsers() throws DAOException {
        List<User> users = new ArrayList<>();

        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_USER)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                User user = initUser(resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return users;
    }


    private User initUser(ResultSet resultSet) throws SQLException {
        User user = new User();

        user.setUserId(resultSet.getInt("user_id"));
        user.setEmail(resultSet.getString("email"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        user.setRole("user");
        user.setBan(resultSet.getString("ban"));

        return user;
    }

}
