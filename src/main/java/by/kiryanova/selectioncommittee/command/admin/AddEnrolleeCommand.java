package by.kiryanova.selectioncommittee.command.admin;

import by.kiryanova.selectioncommittee.command.Command;
import by.kiryanova.selectioncommittee.constant.PageConstant;
import by.kiryanova.selectioncommittee.controller.Router;
import by.kiryanova.selectioncommittee.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class AddEnrolleeCommand implements Command{
    private static final String PARAM_SURNAME = "surname";
    private static final String PARAM_NAME = "name";
    private static final String PARAM_SECOND_NAME = "secondname";
    private static final String PARAM_PASSPORT_ID = "passportID";
    private static final String PARAM_PHONE = "phone";
    private static final String PARAM_FIRST_SUBJECT_NAME = "subject1";
    private static final String PARAM_SECOND_SUBJECT_NAME = "subject2";
    private static final String PARAM_THIRD_SUBJECT_NAME = "subject3";
    private static final String PARAM_FIRST_SUBJECT_POINTS = "points1";
    private static final String PARAM_SECOND_SUBJECT_POINTS = "points2";
    private static final String PARAM_THIRD_SUBJECT_POINTS = "points3";
    private static final String PARAM_CERTIFICATE = "certificate";
    private static final String PARAM_FACULTY = "faculty";
    private static final String PARAM_SPECIALTY = "specialty";

    private UserService receiver;

    public AddEnrolleeCommand(UserService receiver){
        this.receiver = receiver;
    }

    @Override
    public Router execute(HttpServletRequest request)  {
        String page = null;
        Router router = new Router();

        String surname = request.getParameter(PARAM_SURNAME);
        String name = request.getParameter(PARAM_NAME);
        String secondName = request.getParameter(PARAM_SECOND_NAME);
        String passportID = request.getParameter(PARAM_PASSPORT_ID);
        String phone = request.getParameter(PARAM_PHONE);
        String firstSubjectName = request.getParameter(PARAM_FIRST_SUBJECT_NAME);
        String secondSubjectName = request.getParameter(PARAM_SECOND_SUBJECT_NAME);
        String thirdSubjectName = request.getParameter(PARAM_THIRD_SUBJECT_NAME);
        String firstSubjectPoints = request.getParameter(PARAM_FIRST_SUBJECT_POINTS);
        String secondSubjectPoints = request.getParameter(PARAM_SECOND_SUBJECT_POINTS);
        String thirdSubjectPoints = request.getParameter(PARAM_THIRD_SUBJECT_POINTS);
        String certificatePoints = request.getParameter(PARAM_CERTIFICATE);
        String faculty = request.getParameter(PARAM_FACULTY);
        String specialty = request.getParameter(PARAM_SPECIALTY);

        receiver.addEnrollee(surname, name, secondName, passportID, phone, firstSubjectName, secondSubjectName,
                thirdSubjectName, firstSubjectPoints, secondSubjectPoints, thirdSubjectPoints,
                certificatePoints, specialty);


        page = PageConstant.MAIN;

        router.setPagePath(page);
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}
