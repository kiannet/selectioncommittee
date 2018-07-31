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

public class DeleteProfileCommand implements Command {
    private UserService receiver;

    public DeleteProfileCommand(UserService receiver){
        this.receiver = receiver;
    }
    @Override
    public Router execute(HttpServletRequest request) {
        String page = null;
        Router router = new Router();

        HttpSession session = request.getSession();

        User user = (User)session.getAttribute(RoleType.USER);

        try {
            receiver.deleteUserByUserId(user.getUserId());
            page = PageConstant.LOGIN;
        } catch (ServiceException e) {
            //page = PageConstant.LOGIN;
            e.printStackTrace();
        }

        //page = PageConstant.LOGIN;

        router.setPagePath(page);
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}
