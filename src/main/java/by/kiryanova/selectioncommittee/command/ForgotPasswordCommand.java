package by.kiryanova.selectioncommittee.command;

import by.kiryanova.selectioncommittee.controller.Router;
import by.kiryanova.selectioncommittee.entity.User;
import by.kiryanova.selectioncommittee.logic.UserReceiver;

import javax.servlet.http.HttpServletRequest;

public class ForgotPasswordCommand implements Command{
    UserReceiver receiver;

    public ForgotPasswordCommand(UserReceiver receiver){
        this.receiver = receiver;
    }

    @Override
    public Router execute(HttpServletRequest request) {
        String page = null;
        User user;
        Router router = new Router();
        String login = request.getParameter("login");
        String email = request.getParameter("email");



        /*if (DataValidator.validateLoginEmail(login, email)) {
            try {
                user = userService.checkLoginEmailIsExist(login, email);
                if(user != null){
                    String pass = PasswordGenerator.generate();
                    userService.updatePassword(user.getIdUser(), pass);
                    MailSender.sendMail(ParameterConstants.TITLE_EMAIL_MESSAGE, ParameterConstants.TEXT_EMAIL_MESSAGE + pass, email);
                    page =  PageConstants.LOGIN_PAGE;
                    router.setRouteType(Router.RouteType.REDIRECT);
                } else{
                    setErrorMessage(request, MessageConstants.ERROR_EMAIL_LABEL, MessageProperty.ERROR_EMAIL_MESSAGE);
                    router.setRouteType(Router.RouteType.FORWARD);
                    page =  PageConstants.FORGOT_PASS_PAGE;
                }
            } catch (ServiceException e) {
                LOGGER.log(Level.ERROR, e);
            }
        } else {
            setErrorMessage(request, MessageConstants.ERROR_EMAIL_LABEL, MessageProperty.ERROR_EMAIL_MESSAGE);
            router.setRouteType(Router.RouteType.FORWARD);
            page = PageConstants.FORGOT_PASS_PAGE;
        }

        router.setPagePath(page);*/
        return router;
    }
}
