package users;

import entity.User;
import entity.UserDAO;
import utils.UserFormValidator;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "UserEdit", value = "/user/edit")
public class UserEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        try {
            int userId = Integer.parseInt(request.getParameter("id"));
            User user = userDAO.read(userId);
            request.getSession().setAttribute("user", user);
            request.setAttribute("usernameField", user.getUserName());
            request.setAttribute("emailField", user.getEmail());
        } catch (NumberFormatException | NullPointerException e) {
            response.sendError(404);
        }
        if (!response.isCommitted()) {
            getServletContext().getRequestDispatcher("/WEB-INF/users/edit.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (UserFormValidator.validateForm(request)) {
            User editUser = new User();
            HttpSession session = request.getSession();
            User oldUser = (User) session.getAttribute("user");
            editUser.setId(oldUser.getId());
            editUser.setUserName(username);
            editUser.setEmail(email);
            editUser.setPassword(password);
            UserDAO userDAO = new UserDAO();
            if (email.equals(oldUser.getEmail()) || !userDAO.existsByEmail(editUser)) {
                userDAO.update(editUser);
                response.sendRedirect("/user/list");
            } else {
                request.setAttribute("emailError", "Ten email jest już zajęty.");
            }
        }
        if (!response.isCommitted()) {
            getServletContext().getRequestDispatcher("/WEB-INF/users/edit.jsp")
                    .forward(request, response);
        }
    }
}