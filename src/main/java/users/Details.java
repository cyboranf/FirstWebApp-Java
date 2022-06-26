package users;

import entity.User;
import entity.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Details", value = "/user/shows")
public class Details extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        try {
            int userId = Integer.parseInt(request.getParameter("id"));
            User user = userDAO.read(userId);
            request.setAttribute("userId", userId);
            request.setAttribute("usernameField", user.getUserName());
            request.setAttribute("emailField", user.getEmail());
        } catch (NumberFormatException | NullPointerException e) {
            response.sendError(404);
        }
        if (!response.isCommitted()) {
            getServletContext().getRequestDispatcher("/WEB-INF/users/details.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}