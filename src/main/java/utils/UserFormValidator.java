package utils;

import javax.servlet.http.HttpServletRequest;

public class UserFormValidator {
    public static boolean validateForm(HttpServletRequest request) {
        boolean isValid = true;
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (username.equals("")) {
            request.setAttribute("usernameError", "Pole 'Nazwa' nie może być puste.");
            isValid = false;
        } else {
            request.setAttribute("usernameField", username);
        }
        if (email.equals("")) {
            request.setAttribute("emailError", "Pole 'Email' nie może być puste.");
            isValid = false;
        } else {
            request.setAttribute("emailField", email);
        }
        if (password.equals("")) {
            request.setAttribute("passwordError", "Pole 'Hasło' nie może być puste.");
            isValid = false;
        }
        return isValid;
    }
}
