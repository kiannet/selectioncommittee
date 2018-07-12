package by.kiryanova.selectioncommittee.controller;

import by.kiryanova.selectioncommittee.exception.ConnectionException;
import by.kiryanova.selectioncommittee.logic.UniversityReceiver;
import by.kiryanova.selectioncommittee.util.JsonConverter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/specialty")
public class SpecialtyController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            processRequest(request, response);
        } catch (ConnectionException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            processRequest(request, response);
        } catch (ConnectionException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, ConnectionException, SQLException {
        response.setContentType("application/json;charset=UTF-8");
        String facultyId = request.getParameter("faculty");
        UniversityReceiver receiver = new UniversityReceiver();
        List<String> specialties = receiver.findSpecialitiesNamesByFacultyId(facultyId);
        ServletOutputStream out = response.getOutputStream();
        JsonConverter converter = new JsonConverter();
        String output = converter.convertToJson(specialties);
        response.setCharacterEncoding("Cp866");
        out.print(output);
    }
}
