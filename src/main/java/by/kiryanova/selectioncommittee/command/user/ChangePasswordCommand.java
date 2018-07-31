package by.kiryanova.selectioncommittee.command.user;

import by.kiryanova.selectioncommittee.command.Command;
import by.kiryanova.selectioncommittee.constant.PageConstant;
import by.kiryanova.selectioncommittee.constant.RoleType;
import by.kiryanova.selectioncommittee.controller.Router;
import by.kiryanova.selectioncommittee.entity.User;
import by.kiryanova.selectioncommittee.exception.ServiceException;
import by.kiryanova.selectioncommittee.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ChangePasswordCommand implements Command {
    private static final String OLD_PASSWORD = "oldpassword";
    private static final String NEW_PASSWORD = "newpassword";
    private static final String CONFIRMED_NEW_PASSWORD = "confirmnewpassword";


    private UserService receiver;

    public ChangePasswordCommand(UserService receiver){
        this.receiver = receiver;
    }

    @Override
    public Router execute(HttpServletRequest request)  {
        String page = null;
        Router router = new Router();

        String oldPassword = request.getParameter(OLD_PASSWORD);
        String newPassword = request.getParameter(NEW_PASSWORD);
        String confirmedNewPassword = request.getParameter(CONFIRMED_NEW_PASSWORD);

        HttpSession session = request.getSession();

        User user = (User)session.getAttribute(RoleType.USER);
        String usersOldPassword = user.getPassword();

        if (oldPassword.equals(usersOldPassword) && newPassword.equals(confirmedNewPassword)){
            try {
                receiver.updatePassword(newPassword, user.getUserId());
                page = PageConstant.PASSWORD_CHANGED;
            } catch (ServiceException e) {
                //LOG
                e.printStackTrace();
            }
            //page = PageConstant.PASSWORD_CHANGED;
        }
        else {
            request.setAttribute("incorrectpassmess","Incorrect input.");
            page = PageConstant.CHANGE_PASSWORD;
        }

        router.setPagePath(page);
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}
