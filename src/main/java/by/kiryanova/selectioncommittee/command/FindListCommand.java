package by.kiryanova.selectioncommittee.command;

import by.kiryanova.selectioncommittee.constant.PageConstant;
import by.kiryanova.selectioncommittee.controller.Router;
import by.kiryanova.selectioncommittee.entity.Specialty;
import by.kiryanova.selectioncommittee.exception.ConnectionException;
import by.kiryanova.selectioncommittee.exception.RecieverException;
import by.kiryanova.selectioncommittee.logic.UniversityReceiver;
import by.kiryanova.selectioncommittee.logic.UserReceiver;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindListCommand implements Command{
    private static final String UNIVERSITY = "БГУИР";
    private UniversityReceiver receiver;

    public FindListCommand(UniversityReceiver receiver){
        this.receiver = receiver;
    }

    @Override
    public Router execute(HttpServletRequest request)  {
        String page = null;
        Router router = new Router();

        List<String> faculties = new ArrayList<>();
        faculties = receiver.findFacultiesNames(UNIVERSITY);

        request.setAttribute("faculties", faculties);

        List<String> subjects = new ArrayList<>();
        subjects = receiver.findSubjectsNames();

        request.setAttribute("subjects", subjects);

        List<String> specialties = new ArrayList<>();
        specialties = receiver.findSpecialitiesNames("ФИТиУ");

        request.setAttribute("specialties", specialties);

        Map<String, List<String>> specialtiesByFaculty = new HashMap<>();
        specialtiesByFaculty = receiver.findSpecialties();

        request.setAttribute("specialtiesByFaculty", specialtiesByFaculty);

        page = PageConstant.SIGNUP;

        router.setPagePath(page);
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}
