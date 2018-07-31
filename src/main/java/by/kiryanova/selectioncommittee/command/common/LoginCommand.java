package by.kiryanova.selectioncommittee.command.common;

import by.kiryanova.selectioncommittee.command.Command;
import by.kiryanova.selectioncommittee.constant.PageConstant;
import by.kiryanova.selectioncommittee.constant.RoleType;
import by.kiryanova.selectioncommittee.controller.Router;
import by.kiryanova.selectioncommittee.entity.User;
import by.kiryanova.selectioncommittee.exception.ServiceException;
import by.kiryanova.selectioncommittee.service.UserService;
import by.kiryanova.selectioncommittee.validator.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {
    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_PASSWORD = "password";
    private UserService receiver;

    public LoginCommand(UserService receiver){
        this.receiver = receiver;
    }

    @Override
    public Router execute(HttpServletRequest request)  {
        String page = null;
        Router router = new Router();
        String loginValue = request.getParameter(PARAM_LOGIN);
        String passValue = request.getParameter(PARAM_PASSWORD);

        User user;

        if (!loginValue.isEmpty() && !passValue.isEmpty()) {
            try {
                user = receiver.checkUser(loginValue, passValue);
                if (user != null) {
                    request.setAttribute("user", loginValue);
                    page = setRole(request, user);
                } else {
                    //setErrorMessage(request, MessageConstants.ERROR_LOGIN_LABEL, MessageProperty.ERROR_LOGIN_MESSAGE);
                    request.setAttribute("errorLoginPassMessage", "Incorrect login or password.");
                    page = PageConstant.LOGIN;
                }
            } catch (ServiceException e) {
                //e.printStackTrace(); LOG
            }
        }
        else {
            request.setAttribute("errorLoginPassMessage", "Enter login and password.");
            page = PageConstant.LOGIN;
        }

        router.setPagePath(page);
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }

    private String setRole(HttpServletRequest request, User user) {
        HttpSession session = request.getSession();

        switch (user.getRole()) {
            case RoleType.ADMIN:
                session.setAttribute("role", RoleType.ADMIN);
                session.setAttribute(RoleType.ADMIN, user);
                break;
            case RoleType.USER:
                session.setAttribute("role", RoleType.USER);
                session.setAttribute(RoleType.USER, user);
                break;
        }

        return PageConstant.MAIN;
    }
}
