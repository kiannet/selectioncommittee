package by.kiryanova.selectioncommittee.command;

import by.kiryanova.selectioncommittee.controller.Router;
import by.kiryanova.selectioncommittee.exception.ConnectionException;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public interface Command {
    Router execute(HttpServletRequest request) ;
}
