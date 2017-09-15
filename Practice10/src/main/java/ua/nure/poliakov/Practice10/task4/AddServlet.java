package ua.nure.poliakov.Practice10.task4;

import ua.nure.poliakov.Practice10.task4.db.UserDAO;
import ua.nure.poliakov.Practice10.task4.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signUp")
public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String group = req.getParameter("role");
        String name = req.getParameter("name");

        UserDAO userDAO = new UserDAO();

        userDAO.getAllUser();

        if (!userDAO.isExist(login)) {
            userDAO.insert(new User(login, password, group, name));
            resp.sendRedirect("task4\\login.jsp");
            System.out.printf("user %s added to DB", login);
        } else {
            resp.sendRedirect("task4\\task4.jsp");
            System.out.printf("user %s already exist", login);
        }
    }
}
