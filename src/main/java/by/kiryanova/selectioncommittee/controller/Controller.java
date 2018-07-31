package by.kiryanova.selectioncommittee.controller;

import by.kiryanova.selectioncommittee.command.ActionFactory;
import by.kiryanova.selectioncommittee.command.Command;
import by.kiryanova.selectioncommittee.command.common.EmptyCommand;
import by.kiryanova.selectioncommittee.constant.PageConstant;
import by.kiryanova.selectioncommittee.exception.ConnectionException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet("/controller")
public class Controller extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //try {
            processRequest(request, response);
       // } catch (ConnectionException e) {
          //  e.printStackTrace();
        //} catch (SQLException e) {
           // e.printStackTrace();
        //}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       // try {
            processRequest(request, response);
       // } catch (ConnectionException e) {
         //   e.printStackTrace();
       // } catch (SQLException e) {
         //   e.printStackTrace();
       // }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String commandName = request.getParameter("command");
        Optional<Command> commandOptional = ActionFactory.defineCommand(commandName);
        Command command = commandOptional.orElse(new EmptyCommand());

        Router router = command.execute(request);
        if (router != null) {
            String page = router.getPagePath();
            switch (router.getRouteType()){
                case FORWARD:{
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
                    requestDispatcher.forward(request, response);
                    break;
                }
                case REDIRECT:{
                    response.sendRedirect(request.getContextPath() + page);
                    break;
                }
                default:{
                    response.sendRedirect(PageConstant.ERROR);
                }
            }
        } else {
            request.getSession().invalidate();
            response.sendRedirect(PageConstant.MAIN);
        }

    }
}
