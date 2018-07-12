package by.kiryanova.selectioncommittee.command;

import by.kiryanova.selectioncommittee.constant.PageConstant;
import by.kiryanova.selectioncommittee.controller.Router;
import by.kiryanova.selectioncommittee.entity.University;
import by.kiryanova.selectioncommittee.exception.ConnectionException;
import by.kiryanova.selectioncommittee.logic.UniversityReceiver;
import by.kiryanova.selectioncommittee.logic.UserReceiver;
import by.kiryanova.selectioncommittee.validator.Validator;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SignupCommand implements Command{
    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_PASSWORD = "password";
    private static final String PARAM_CHECK_PASSWORD = "passwordcheck";
    private static final String PARAM_EMAIL = "email";
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

    private UserReceiver receiver;
    private UniversityReceiver universityReceiver = new UniversityReceiver();

    public SignupCommand(UserReceiver receiver){
        this.receiver = receiver;
    }

    @Override
    public Router execute(HttpServletRequest request)  {
        String page = null;
        Router router = new Router();
        String login = request.getParameter(PARAM_LOGIN);
        String password= request.getParameter(PARAM_PASSWORD);
        String checkPassword = request.getParameter(PARAM_CHECK_PASSWORD);
        String email = request.getParameter(PARAM_EMAIL);
        String surname = request.getParameter(PARAM_SURNAME);
        String name = request.getParameter(PARAM_NAME);
        String second_name = request.getParameter(PARAM_SECOND_NAME);
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


        if (Validator.validateSignup(name, second_name, surname, email, login, password, checkPassword, passportID, phone,
                firstSubjectName, secondSubjectName, thirdSubjectName, firstSubjectPoints, secondSubjectPoints, thirdSubjectPoints, certificatePoints, faculty)){

            if(Validator.ifPasswordIsConfirmed(password, checkPassword)){
                receiver.addUser(login, password, email,
                        surname, name, second_name, passportID, phone,
                        firstSubjectName, secondSubjectName, thirdSubjectName,
                        firstSubjectPoints, secondSubjectPoints, thirdSubjectPoints,
                        certificatePoints, specialty);

                //request.setAttribute();
                page = PageConstant.SIGNEDUP;
            }
            else {
                request.setAttribute("errorConfirmMessage", "Passwords are not equals...");

                List<String> faculties = new ArrayList<>();
                faculties = universityReceiver.findFacultiesNames("БГУИР");

                request.setAttribute("faculties", faculties);

                List<String> subjects = new ArrayList<>();
                subjects = universityReceiver.findSubjectsNames();

                request.setAttribute("subjects", subjects);

                List<String> specialties = new ArrayList<>();
                specialties = universityReceiver.findSpecialitiesNames("ФИТиУ");

                request.setAttribute("specialties", specialties);

                Map<String, List<String>> specialtiesByFaculty = new HashMap<>();
                specialtiesByFaculty = universityReceiver.findSpecialties();

                request.setAttribute("specialtiesByFaculty", specialtiesByFaculty);

                page = PageConstant.SIGNUP;
            }
        }
        else {
            request.setAttribute("enter", "*");
            request.setAttribute("errorEmptyValuesMessage", "Enter all values.");

            List<String> faculties = new ArrayList<>();
            faculties = universityReceiver.findFacultiesNames("БГУИР");

            request.setAttribute("faculties", faculties);

            List<String> subjects = new ArrayList<>();
            subjects = universityReceiver.findSubjectsNames();

            request.setAttribute("subjects", subjects);

            List<String> specialties = new ArrayList<>();
            specialties = universityReceiver.findSpecialitiesNames("ФИТиУ");

            request.setAttribute("specialties", specialties);

            Map<String, List<String>> specialtiesByFaculty = new HashMap<>();
            specialtiesByFaculty = universityReceiver.findSpecialties();

            request.setAttribute("specialtiesByFaculty", specialtiesByFaculty);

            page = PageConstant.SIGNUP;
        }



        router.setPagePath(page);
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}
