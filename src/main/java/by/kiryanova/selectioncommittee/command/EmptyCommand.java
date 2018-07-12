package by.kiryanova.selectioncommittee.command;

import by.kiryanova.selectioncommittee.controller.Router;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements Command{
    @Override
    public Router execute(HttpServletRequest request) {
        return null;
    }
}
