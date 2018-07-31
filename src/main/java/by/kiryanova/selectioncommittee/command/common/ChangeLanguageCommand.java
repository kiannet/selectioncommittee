package by.kiryanova.selectioncommittee.command.common;

import by.kiryanova.selectioncommittee.command.Command;
import by.kiryanova.selectioncommittee.constant.PageConstant;
import by.kiryanova.selectioncommittee.controller.Router;

import javax.servlet.http.HttpServletRequest;

public class ChangeLanguageCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();

        String locale = request.getParameter("locale");
        String page = PageConstant.CAROUSEL;
        request.getSession().setAttribute("locale", locale);

        router.setPagePath(page);
        router.setRouteType(Router.RouteType.FORWARD);

        return router;
    }
}
