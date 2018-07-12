package by.kiryanova.selectioncommittee.command;

import by.kiryanova.selectioncommittee.constant.PageConstant;
import by.kiryanova.selectioncommittee.controller.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MoreAboutFacultyCommand implements Command {

    @Override
    public Router execute(HttpServletRequest request) {
        String faculty = request.getParameter("faculty");

        String page = null;
        Router router = new Router();

        request.setAttribute("faculty", faculty);
        page = PageConstant.MOREABOUTFACULTY;

        router.setPagePath(page);
        router.setRouteType(Router.RouteType.FORWARD);
        return router;

    }
}
