package by.kiryanova.selectioncommittee.command;

import by.kiryanova.selectioncommittee.constant.PageConstant;
import by.kiryanova.selectioncommittee.controller.Router;
import by.kiryanova.selectioncommittee.logic.UniversityReceiver;
import by.kiryanova.selectioncommittee.logic.UserReceiver;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ToFacultiesCommand implements Command{
    private UniversityReceiver receiver;

    public ToFacultiesCommand(UniversityReceiver receiver){
        this.receiver = receiver;
    }

    @Override
    public Router execute(HttpServletRequest request)  {
        String page = null;
        Router router = new Router();
        List<String> faculties = receiver.findFacultiesNames("БГУИР");

        request.setAttribute("faculties", faculties);

        page = PageConstant.FACULTIES;

        router.setPagePath(page);
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}
