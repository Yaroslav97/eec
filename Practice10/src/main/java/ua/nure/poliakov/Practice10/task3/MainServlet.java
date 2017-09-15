package ua.nure.poliakov.Practice10.task3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/task3")
public class MainServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Login list = new Login();

        String name = req.getParameter("name");
        if (!name.equals("")) {
            list.add(name);

        }else {
            System.out.println("incorrect input data");
        }

        System.out.println(list.getList());
        if (!name.equals("")){
        session.setAttribute("list", list.getList());
        }

        resp.sendRedirect("task3\\task3.jsp");
    }
}