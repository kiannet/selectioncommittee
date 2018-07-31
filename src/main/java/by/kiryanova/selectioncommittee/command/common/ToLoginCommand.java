package by.kiryanova.selectioncommittee.command.common;

import by.kiryanova.selectioncommittee.command.Command;
import by.kiryanova.selectioncommittee.constant.PageConstant;
import by.kiryanova.selectioncommittee.controller.Router;
import by.kiryanova.selectioncommittee.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class ToLoginCommand implements Command {
    private UserService receiver;

    public ToLoginCommand(UserService receiver){
        this.receiver = receiver;
    }

    @Override
    public Router execute(HttpServletRequest request)  {
        String page = null;
        Router router = new Router();

        page = PageConstant.LOGIN;

        router.setPagePath(page);
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}
