package by.kiryanova.selectioncommittee.dao;

import by.kiryanova.selectioncommittee.exception.ConnectionException;
import by.kiryanova.selectioncommittee.exception.DAOException;

import java.sql.SQLException;
@Deprecated
public interface IUserDAO {
    boolean matchUsernamePassword(String usernameValue, String passwordValue) throws ConnectionException, SQLException, DAOException;

}
