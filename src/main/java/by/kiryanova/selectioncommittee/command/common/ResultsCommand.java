package by.kiryanova.selectioncommittee.command.common;

import by.kiryanova.selectioncommittee.command.Command;
import by.kiryanova.selectioncommittee.constant.PageConstant;
import by.kiryanova.selectioncommittee.controller.Router;
import by.kiryanova.selectioncommittee.service.CommonService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ResultsCommand implements Command {
    private static final String UNIVERSITY = "БГУИР";
    private CommonService receiver;

    public ResultsCommand(CommonService receiver){
        this.receiver = receiver;
    }

    @Override
    public Router execute(HttpServletRequest request) {
        String page = null;
        Router router = new Router();

        List<String> faculties = new ArrayList<>();
        faculties = receiver.findFacultiesNames(UNIVERSITY);

        request.setAttribute("faculties", faculties);

        List<String> specialties = new ArrayList<>();
        specialties = receiver.findSpecialitiesNames("ФИТиУ");

        request.setAttribute("specialties", specialties);
        page = PageConstant.RESULTS;

        router.setPagePath(page);
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}
