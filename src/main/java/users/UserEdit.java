package users;

import entity.User;
import entity.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserEdit", value = "/user/edit")
public class UserEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        entity.User user;
        if (id == null) {
            user = new entity.User(-1, "", "", "");
        } else {
            UserDao userDao = new UserDao();
            user = userDao.read(Integer.parseInt(id));
        }
        request.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/users/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> errorMessages = new ArrayList<>();
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //sprawdzenie danych wejściowych
        if (userName == "") {
            errorMessages.add("Nazwa użytkownika nie może być pusta.");
        }
        if (!email.matches(entity.User.emailRegex)) {
            errorMessages.add("Niepoprawny adres email.");
        }
        if (password.length() < 8) {
            errorMessages.add("Hasło zbyt krótkie.");
        }
        int id = -2;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            errorMessages.add("Niepoprawny numer id");
        }
        User user = new User(id, userName, email, password);
        if (errorMessages.size() > 0) {
            request.setAttribute("messages", errorMessages);
            request.setAttribute("user", user);
            getServletContext().getRequestDispatcher("/users/edit.jsp").forward(request, response);
            return;
        }
        UserDao userDao = new UserDao();
        if (id == -1) {
            userDao.create(user);
        } else {
            userDao.update(user);
        }
        response.sendRedirect("/user/list");
    }
}