package by.kiryanova.selectioncommittee.command;

import by.kiryanova.selectioncommittee.constant.PageConstant;
import by.kiryanova.selectioncommittee.constant.RoleType;
import by.kiryanova.selectioncommittee.controller.Router;
import by.kiryanova.selectioncommittee.entity.Enrollee;
import by.kiryanova.selectioncommittee.entity.User;
import by.kiryanova.selectioncommittee.logic.UserReceiver;
import by.kiryanova.selectioncommittee.validator.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ProfileCommand implements Command{

    private UserReceiver receiver;

    public ProfileCommand(UserReceiver receiver){
        this.receiver = receiver;
    }

    @Override
    public Router execute(HttpServletRequest request)  {
        String page = null;
        Router router = new Router();

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute(RoleType.USER);
        Enrollee enrollee = receiver.findEnrollee(user.getUsername());

        request.setAttribute("username", user.getUsername());
        request.setAttribute("email", user.getEmail());
        request.setAttribute("name", enrollee.getName());
        request.setAttribute("secondname", enrollee.getSecondName());
        request.setAttribute("surname", enrollee.getSurname());
        request.setAttribute("passportid", enrollee.getPassportId());
        request.setAttribute("phone", enrollee.getPhone());
        request.setAttribute("specialty", enrollee.getSpecialty());
        request.setAttribute("fsubjectname", enrollee.getSubjectNames().get(0));
        request.setAttribute("fpoints", enrollee.getPoints().get(0));
        request.setAttribute("ssubjectname", enrollee.getSubjectNames().get(1));
        request.setAttribute("spoints", enrollee.getPoints().get(1));
        request.setAttribute("tsubjectname", enrollee.getSubjectNames().get(2));
        request.setAttribute("tpoints", enrollee.getPoints().get(2));
        request.setAttribute("certificate", enrollee.getCertificate());

        page = PageConstant.PROFILE;


        router.setPagePath(page);
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}
