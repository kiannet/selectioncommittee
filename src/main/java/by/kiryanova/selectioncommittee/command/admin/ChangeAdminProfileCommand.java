package by.kiryanova.selectioncommittee.command.admin;

import by.kiryanova.selectioncommittee.command.Command;
import by.kiryanova.selectioncommittee.constant.PageConstant;
import by.kiryanova.selectioncommittee.constant.RoleType;
import by.kiryanova.selectioncommittee.controller.Router;
import by.kiryanova.selectioncommittee.entity.User;
import by.kiryanova.selectioncommittee.exception.ServiceException;
import by.kiryanova.selectioncommittee.service.AdminService;
import by.kiryanova.selectioncommittee.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ChangeAdminProfileCommand implements Command{

    private AdminService receiver;

    public ChangeAdminProfileCommand(AdminService receiver){
        this.receiver = receiver;
    }

    @Override
    public Router execute(HttpServletRequest request)  {
        String page = null;
        Router router = new Router();

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute(RoleType.ADMIN);

        String username = request.getParameter("username");
        String email = request.getParameter("email");


        try {
            receiver.updateAdminProfile(username, email, user.getUserId());
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        page = PageConstant.CAROUSEL;

        router.setPagePath(page);
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}
