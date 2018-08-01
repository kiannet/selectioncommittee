package by.kiryanova.selectioncommittee.command.admin;

import by.kiryanova.selectioncommittee.command.Command;
import by.kiryanova.selectioncommittee.constant.PageConstant;
import by.kiryanova.selectioncommittee.constant.RoleType;
import by.kiryanova.selectioncommittee.controller.Router;
import by.kiryanova.selectioncommittee.entity.User;
import by.kiryanova.selectioncommittee.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UsersCommand implements Command{
    private UserService receiver;

    public UsersCommand(UserService receiver){
        this.receiver = receiver;
    }

    @Override
    public Router execute(HttpServletRequest request)  {
        String page = null;
        Router router = new Router();

        //HttpSession session = request.getSession();
        //User user = (User)session.getAttribute(RoleType.USER);

        List<User> users = receiver.findAllUsers();
        request.setAttribute("users", users);

        //request.setAttribute("username", user.getUsername());
        //request.setAttribute("email", user.getEmail());

        page = PageConstant.USERS_TABLE;

        router.setPagePath(page);
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}
