package users;

import entity.User;
import entity.UserDAO;
import utils.UserFormValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "UserAdd", value = "/user/add")
public class UserAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/users/add.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (UserFormValidator.validateForm(request)) {
            User newUser = new User();
            newUser.setUserName(username);
            newUser.setEmail(email);
            newUser.setPassword(password);
            UserDAO userDAO = new UserDAO();
            if (!userDAO.existsByEmail(newUser)) {
                userDAO.create(newUser);
                response.sendRedirect("/user/list");
            } else {
                request.setAttribute("emailError", "Ten email jest już zajęty.");
            }
        }
        if (!response.isCommitted()) {
            getServletContext().getRequestDispatcher("/WEB-INF/users/add.jsp")
                    .forward(request, response);
        }

    }
}



