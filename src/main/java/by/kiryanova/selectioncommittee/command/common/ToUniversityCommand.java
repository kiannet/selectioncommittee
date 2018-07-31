package by.kiryanova.selectioncommittee.command.common;

import by.kiryanova.selectioncommittee.command.Command;
import by.kiryanova.selectioncommittee.constant.PageConstant;
import by.kiryanova.selectioncommittee.controller.Router;
import by.kiryanova.selectioncommittee.service.CommonService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ToUniversityCommand implements Command {
    private CommonService receiver;

    public ToUniversityCommand(CommonService receiver){
        this.receiver = receiver;
    }

    @Override
    public Router execute(HttpServletRequest request)  {
        String page = null;
        Router router = new Router();

        List<String> faculties = receiver.findFacultiesNames("БГУИР");

        request.setAttribute("university", "Белорусский государственный университет информатики и радиоэлектроники");
        request.setAttribute("faculties", faculties);

        page = PageConstant.UNIVERSITY;

        router.setPagePath(page);
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}
