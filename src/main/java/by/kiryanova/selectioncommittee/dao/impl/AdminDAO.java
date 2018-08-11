package by.kiryanova.selectioncommittee.dao.impl;

import by.kiryanova.selectioncommittee.exception.DAOException;
import by.kiryanova.selectioncommittee.pool.ConnectionPool;
import by.kiryanova.selectioncommittee.pool.ProxyConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicBoolean;

public class AdminDAO {
    private static final String INSERT_ENROLLEE = "";
    private static final String BAN_USER = "UPDATE users SET ban='true' WHERE user_id=?";
    private static final String UNBAN_USER = "UPDATE users SET ban='false' WHERE user_id=?";
    private static final String UPDATE_INFO = "UPDATE users SET username=?, email=? WHERE user_id=?";

    private static final AdminDAO INSTANCE;
    private static AtomicBoolean instanceCreated = new AtomicBoolean(false);

    static {
        INSTANCE = new AdminDAO();
        instanceCreated.set(true);
    }

    private AdminDAO(){
        if (instanceCreated.get()) {
            //LOGGER.log(Level.FATAL, "Tried to create singleton object with reflection api");
            throw new RuntimeException("Tried to create singleton object with reflection api");
        }
    }

    public static AdminDAO getInstance() {
        return INSTANCE;
    }

    public void addEnrollee(String surname, String name, String secondName, String passportId, String phone, String certificate ){

    }

    public void banUser(int userId) throws DAOException {
        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(BAN_USER)) {
            statement.setInt(1, userId);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public void unbanUser(int userId) throws DAOException {
        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UNBAN_USER)) {
            statement.setInt(1, userId);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public void updateAdminProfile(String username, String email, int userId) throws DAOException {
        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_INFO)) {
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setInt(3, userId);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
