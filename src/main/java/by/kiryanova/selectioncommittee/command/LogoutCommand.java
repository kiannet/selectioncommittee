package by.kiryanova.selectioncommittee.command;

import by.kiryanova.selectioncommittee.constant.PageConstant;
import by.kiryanova.selectioncommittee.controller.Router;
import by.kiryanova.selectioncommittee.logic.DefaultReceiver;
import by.kiryanova.selectioncommittee.logic.UserReceiver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command{

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
