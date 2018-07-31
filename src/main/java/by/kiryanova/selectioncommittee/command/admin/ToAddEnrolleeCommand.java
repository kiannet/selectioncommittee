package by.kiryanova.selectioncommittee.command.admin;

import by.kiryanova.selectioncommittee.command.Command;
import by.kiryanova.selectioncommittee.constant.PageConstant;
import by.kiryanova.selectioncommittee.constant.RoleType;
import by.kiryanova.selectioncommittee.controller.Router;
import by.kiryanova.selectioncommittee.entity.User;
import by.kiryanova.selectioncommittee.service.CommonService;
import by.kiryanova.selectioncommittee.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToAddEnrolleeCommand implements Command{
    private CommonService receiver;

    public ToAddEnrolleeCommand(CommonService receiver){
        this.receiver = receiver;
    }

    @Override
    public Router execute(HttpServletRequest request)  {
        String page = null;
        Router router = new Router();

        List<String> faculties = new ArrayList<>();
        faculties = receiver.findFacultiesNames("БГУИР");

        request.setAttribute("faculties", faculties);

        List<String> subjects;
        subjects = receiver.findSubjectsNames();

        request.setAttribute("subjects", subjects);

        List<String> specialties = new ArrayList<>();
        specialties = receiver.findSpecialitiesNames("");

        request.setAttribute("specialties", specialties);

        Map<String, List<String>> specialtiesByFaculty = new HashMap<>();
        specialtiesByFaculty = receiver.findSpecialties();

        request.setAttribute("specialtiesByFaculty", specialtiesByFaculty);

        page = PageConstant.ADD_ENROLLEE;

        router.setPagePath(page);
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}
