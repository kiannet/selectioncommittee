package by.kiryanova.selectioncommittee.command;

import by.kiryanova.selectioncommittee.constant.PageConstant;
import by.kiryanova.selectioncommittee.controller.Router;
import by.kiryanova.selectioncommittee.logic.UserReceiver;

import javax.servlet.http.HttpServletRequest;

public class ChangeProfileCommand implements Command{

    private UserReceiver receiver;

    public  ChangeProfileCommand(UserReceiver receiver){
        this.receiver = receiver;
    }

    @Override
    public Router execute(HttpServletRequest request) {
        String page = null;
        Router router = new Router();
        //List<String> faculties = receiver.findFacultiesNames("БГУИР");

        //request.setAttribute("faculties", faculties);

        page = PageConstant.PROFILECHANGED;

        router.setPagePath(page);
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}
