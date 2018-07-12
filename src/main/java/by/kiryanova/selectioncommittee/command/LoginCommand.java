package by.kiryanova.selectioncommittee.command;

import by.kiryanova.selectioncommittee.constant.PageConstant;
import by.kiryanova.selectioncommittee.constant.RoleType;
import by.kiryanova.selectioncommittee.controller.Router;
import by.kiryanova.selectioncommittee.entity.User;
import by.kiryanova.selectioncommittee.exception.ConnectionException;
import by.kiryanova.selectioncommittee.logic.UniversityReceiver;
import by.kiryanova.selectioncommittee.logic.UserReceiver;
import by.kiryanova.selectioncommittee.validator.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class LoginCommand implements Command{
    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_PASSWORD = "password";
    private UserReceiver receiver;

    public LoginCommand(UserReceiver receiver){
        this.receiver = receiver;
    }

    @Override
    public Router execute(HttpServletRequest request)  {
        String page = null;
        Router router = new Router();
        String loginValue = request.getParameter(PARAM_LOGIN);
        String passValue = request.getParameter(PARAM_PASSWORD);


        if (Validator.validateLogin(loginValue, passValue)){
            User user;

            user = receiver.checkUser(loginValue, passValue);
            if (user != null){
                request.setAttribute("user", loginValue);
                page = setRole(request, user);
            }
            else {
                request.setAttribute("errorLoginPassMessage", "Incorrect login or password.");
                page = PageConstant.LOGIN;
            }
        }
        else {
            request.setAttribute("emptyUsernameOrPassword", "Enter username and password.");
            page = PageConstant.LOGIN;
        }

        router.setPagePath(page);
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }

    private String setRole(HttpServletRequest request, User user) {
        HttpSession session = request.getSession();

        switch (user.getRole()) {
            case RoleType.ADMIN_ROLE:
                session.setAttribute("role", RoleType.ADMIN);
                session.setAttribute(RoleType.ADMIN, user);
                break;
            case RoleType.USER_ROLE:
                session.setAttribute("role", RoleType.USER);
                session.setAttribute(RoleType.USER, user);
                break;
        }

        return PageConstant.MAIN;
    }
}
