package ua.nure.poliakov.Practice10.task4;

import ua.nure.poliakov.Practice10.task4.db.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDAO userDAO = new UserDAO();
        String name = req.getParameter("name");

        if (!name.equals("") && name.length() > 0){
            userDAO.updateName(name, userDAO.getLoginByName(name));
            session.setAttribute("name", name);
            resp.sendRedirect("index.jsp");
        }else {
            resp.sendRedirect("task4\\edit.jsp");
        }
    }
}