package by.kiryanova.selectioncommittee.command.common;

import by.kiryanova.selectioncommittee.command.Command;
import by.kiryanova.selectioncommittee.constant.PageConstant;
import by.kiryanova.selectioncommittee.controller.Router;
import by.kiryanova.selectioncommittee.service.DefaultReceiver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {

    public LogoutCommand(DefaultReceiver receiver){

    }

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        HttpSession httpSession = request.getSession(false);

        if (httpSession != null){
            httpSession.invalidate();
        }

        router.setPagePath(PageConstant.INDEX);
        router.setRouteType(Router.RouteType.REDIRECT);

        return router;
    }
}
