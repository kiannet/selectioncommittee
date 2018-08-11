package by.kiryanova.selectioncommittee.command.admin;

import by.kiryanova.selectioncommittee.command.Command;
import by.kiryanova.selectioncommittee.constant.PageConstant;
import by.kiryanova.selectioncommittee.controller.Router;
import by.kiryanova.selectioncommittee.exception.ServiceException;
import by.kiryanova.selectioncommittee.service.AdminService;

import javax.servlet.http.HttpServletRequest;

public class UnbanUserCommand implements Command{
    private AdminService service;

    public UnbanUserCommand(AdminService service){
        this.service = service;
    }

    @Override
    public Router execute(HttpServletRequest request)  {
        String page = null;
        Router router = new Router();


        try {
            service.banUserByUserId(Integer.parseInt(request.getParameter("id")));
        } catch (ServiceException e) {
            e.printStackTrace();
        }


        page = PageConstant.CAROUSEL;

        router.setPagePath(page);
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}
