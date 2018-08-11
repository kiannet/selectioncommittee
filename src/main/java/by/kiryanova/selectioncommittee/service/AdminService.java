package by.kiryanova.selectioncommittee.service;

import by.kiryanova.selectioncommittee.dao.impl.AdminDAO;
import by.kiryanova.selectioncommittee.exception.DAOException;
import by.kiryanova.selectioncommittee.exception.ServiceException;

public class AdminService {
    AdminDAO adminDAO = AdminDAO.getInstance();

    public void banUserByUserId(int userId) throws ServiceException {
        try {
            adminDAO.banUser(userId);
        } catch (DAOException e) {
            throw new ServiceException(e);
            // e.printStackTrace();
        }
    }

    public void unbanUserByUserId(int userId) throws ServiceException {
        try {
            adminDAO.unbanUser(userId);
        } catch (DAOException e) {
            throw new ServiceException(e);
            // e.printStackTrace();
        }
    }
}
