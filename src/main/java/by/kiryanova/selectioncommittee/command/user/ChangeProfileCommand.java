package by.kiryanova.selectioncommittee.command.user;

import by.kiryanova.selectioncommittee.command.Command;
import by.kiryanova.selectioncommittee.constant.PageConstant;
import by.kiryanova.selectioncommittee.constant.RoleType;
import by.kiryanova.selectioncommittee.controller.Router;
import by.kiryanova.selectioncommittee.entity.User;
import by.kiryanova.selectioncommittee.exception.ServiceException;
import by.kiryanova.selectioncommittee.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ChangeProfileCommand implements Command {

    private static final String SURNAME = "surname";
    private static final String NAME = "name";
    private static final String SECOND_NAME = "secondname";
    private static final String PASSPORT_ID = "passportID";
    private static final String PHONE = "phone";

    private UserService receiver;

    public ChangeProfileCommand(UserService receiver){
        this.receiver = receiver;
    }

    @Override
    public Router execute(HttpServletRequest request)  {
        String page = null;
        Router router = new Router();

        String surname = request.getParameter(SURNAME);
        String name = request.getParameter(NAME);
        String secondName = request.getParameter(SECOND_NAME);
        String passportID = request.getParameter(PASSPORT_ID);
        String phone = request.getParameter(PHONE);

        HttpSession session = request.getSession();

        User user = (User)session.getAttribute(RoleType.USER);

        try {
            receiver.updateEnrolleeInfo(surname, name, secondName, passportID, phone, user.getUserId());
            page = PageConstant.PROFILE_CHANGED;
        } catch (ServiceException e) {
            page = PageConstant.ERROR;
            e.printStackTrace();
        }

        //page = PageConstant.PROFILE_CHANGED;

        router.setPagePath(page);
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}
