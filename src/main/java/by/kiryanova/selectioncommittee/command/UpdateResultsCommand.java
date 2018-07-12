package by.kiryanova.selectioncommittee.command;

import by.kiryanova.selectioncommittee.constant.PageConstant;
import by.kiryanova.selectioncommittee.controller.Router;
import by.kiryanova.selectioncommittee.entity.Enrollee;
import by.kiryanova.selectioncommittee.logic.UniversityReceiver;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UpdateResultsCommand implements Command{

    private UniversityReceiver receiver;

    public UpdateResultsCommand(UniversityReceiver receiver){
        this.receiver = receiver;
    }

    @Override
    public Router execute(HttpServletRequest request) {

        String page = null;
        Router router = new Router();

        List<Enrollee> enrollees = receiver.findEnrollees(request.getParameter("specialty"));
        request.setAttribute("enrollees", enrollees);
        request.setAttribute("specialty", request.getParameter("specialty"));

        page = PageConstant.TABLE;
        router.setPagePath(page);
        router.setRouteType(Router.RouteType.FORWARD);
        return router;

    }
}
