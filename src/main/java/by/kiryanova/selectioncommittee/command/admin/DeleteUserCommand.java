package by.kiryanova.selectioncommittee.command.admin;

import by.kiryanova.selectioncommittee.command.Command;
import by.kiryanova.selectioncommittee.constant.PageConstant;
import by.kiryanova.selectioncommittee.controller.Router;
import by.kiryanova.selectioncommittee.exception.ServiceException;
import by.kiryanova.selectioncommittee.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class DeleteUserCommand implements Command{
    private UserService receiver;

    public DeleteUserCommand(UserService receiver){
        this.receiver = receiver;
    }

    @Override
    public Router execute(HttpServletRequest request)  {
        String page = null;
        Router router = new Router();

        try {
            receiver.deleteUserByUserId(Integer.parseInt(request.getParameter("id")));
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        page = PageConstant.CAROUSEL;

        router.setPagePath(page);
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}
