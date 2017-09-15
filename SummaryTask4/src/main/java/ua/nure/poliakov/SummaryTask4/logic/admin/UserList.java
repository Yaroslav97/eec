package ua.nure.poliakov.SummaryTask4.logic.admin;

import org.apache.log4j.Logger;
import ua.nure.poliakov.SummaryTask4.dao.user_dao.UserDAO;
import ua.nure.poliakov.SummaryTask4.dao.user_dao.UserDAOImplement;
import ua.nure.poliakov.SummaryTask4.utils.user.UsersList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userList")
public class UserList extends HttpServlet {

    private static final Logger log = Logger.getLogger(UserList.class);
    private UserDAO userDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userDAO = new UserDAOImplement();
        req.getSession().setAttribute("userList", userDAO.getAllUsersByRole("user"));
        resp.setIntHeader("Refresh", 200);
        log.info("UserList page: " + req.getSession().getAttribute("authenticatedLogin"));
        req.getRequestDispatcher("admin//user_list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsersList.getUsers(req, resp);
    }
}
