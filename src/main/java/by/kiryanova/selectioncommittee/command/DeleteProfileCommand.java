package by.kiryanova.selectioncommittee.command;

import by.kiryanova.selectioncommittee.constant.PageConstant;
import by.kiryanova.selectioncommittee.constant.RoleType;
import by.kiryanova.selectioncommittee.controller.Router;
import by.kiryanova.selectioncommittee.entity.User;
import by.kiryanova.selectioncommittee.logic.UserReceiver;
import by.kiryanova.selectioncommittee.validator.Validator;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class DeleteProfileCommand implements Command{
    private UserReceiver receiver;

    public DeleteProfileCommand(UserReceiver receiver){
        this.receiver = receiver;
    }
    @Override
    public Router execute(HttpServletRequest request) {
        String page = null;
        Router router = new Router();

        HttpSession session = request.getSession();

        User user = (User)session.getAttribute(RoleType.USER);

        receiver.deleteUserByUserId(user.getUserId());

        page = PageConstant.LOGIN;

        router.setPagePath(page);
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}
