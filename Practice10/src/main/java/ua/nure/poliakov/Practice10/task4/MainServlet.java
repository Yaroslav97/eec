package ua.nure.poliakov.Practice10.task4;

import ua.nure.poliakov.Practice10.task4.db.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/signIn")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        UserDAO userDAO = new UserDAO();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        userDAO.getAllUser();

        if (session.getAttribute("login") == "") {
            resp.sendRedirect("task4\\login.jsp");
        }

        if (login.length() > 0 && password.length() > 0 && userDAO.isExist(login) &&
                userDAO.getPassword(login).equals(password)) {
            session.setAttribute("login", userDAO.getLogin(login));
            session.setAttribute("group", userDAO.getGroup(login));
            session.setAttribute("name", userDAO.getName(login));
            resp.sendRedirect("index.jsp");
        } else {
            resp.sendRedirect("task4\\login.jsp");
        }
    }
}