package by.kiryanova.selectioncommittee.command.common;

import by.kiryanova.selectioncommittee.command.Command;
import by.kiryanova.selectioncommittee.constant.PageConstant;
import by.kiryanova.selectioncommittee.controller.Router;
import by.kiryanova.selectioncommittee.service.CommonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class MoreAboutFacultyCommand implements Command {

    private CommonService receiver;

    public MoreAboutFacultyCommand(CommonService receiver){

        this.receiver = receiver;
    }

    @Override
    public Router execute(HttpServletRequest request) {
        String faculty = request.getParameter("faculty");


        String page = null;
        Router router = new Router();

        List<String> specialities = receiver.findSpecialitiesNames(faculty);
        String description = receiver.findFacultyDescriptiom(faculty);

        request.setAttribute("faculty", faculty);
        request.setAttribute("specialties", specialities);
        request.setAttribute("description", description);


        page = PageConstant.MORE_ABOUT_FACULTY;

        router.setPagePath(page);
        router.setRouteType(Router.RouteType.FORWARD);
        return router;

    }
}
