package by.kiryanova.selectioncommittee.command.user;

import by.kiryanova.selectioncommittee.command.Command;
import by.kiryanova.selectioncommittee.constant.PageConstant;
import by.kiryanova.selectioncommittee.constant.RoleType;
import by.kiryanova.selectioncommittee.controller.Router;
import by.kiryanova.selectioncommittee.entity.Enrollee;
import by.kiryanova.selectioncommittee.entity.User;
import by.kiryanova.selectioncommittee.exception.ServiceException;
import by.kiryanova.selectioncommittee.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ToChangeProfileCommand implements Command {
    private UserService receiver;

    public ToChangeProfileCommand(UserService receiver){
        this.receiver = receiver;
    }

    @Override
    public Router execute(HttpServletRequest request) {
        String page = null;
        Router router = new Router();

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute(RoleType.USER);
        Enrollee enrollee = null;
        try {
            enrollee = receiver.findEnrollee(user.getUsername());


        request.setAttribute("username", user.getUsername());
        request.setAttribute("name", enrollee.getName());
        request.setAttribute("secondname", enrollee.getSecondName());
        request.setAttribute("surname", enrollee.getSurname());
        request.setAttribute("passportid", enrollee.getPassportId());
        request.setAttribute("phone", enrollee.getPhone());

        page = PageConstant.CHANGE_PROFILE;

        } catch (ServiceException e) {
            e.printStackTrace();
        }

        router.setPagePath(page);
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}
