package users;

import entity.User;
import entity.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ConfOfDeletion", value = "/user/get")
public class ConfOfDeletion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        try {
            int userId = Integer.parseInt(request.getParameter("id"));
            User user = userDAO.read(userId);
            response.setContentType("text/plain");
            response.getWriter().write(user.getUserName());
        } catch (NumberFormatException | NullPointerException e) {
            response.sendError(404);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}