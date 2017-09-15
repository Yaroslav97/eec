package ua.nure.poliakov.Practice9.task2;

import ua.nure.poliakov.Practice9.task2.entity.Basketball;
import ua.nure.poliakov.Practice9.task2.entity.Biathlon;
import ua.nure.poliakov.Practice9.task2.entity.Football;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/vote")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        ServletContext context = getServletContext();

        String vote = req.getParameter("vote");
        String name = req.getParameter("name");

        if (!name.equals("")) {
            switch (vote) {
                case "Football":
                    if (!Football.isExist(name) && !Biathlon.isExist(name) && !Basketball.isExist(name)) {
                        Football.add(name);
                        context.setAttribute("scoreFootball", Football.getList().size());
                        context.setAttribute("nameFootball", Football.getList());
                        System.out.println(name);
                        session.invalidate();
                        resp.sendRedirect("task2\\vote.jsp");
                    } else {
                        resp.sendRedirect("task2\\info.jsp");
                    }
                    break;

                case "Biathlon":
                    if (!Football.isExist(name) && !Biathlon.isExist(name) && !Basketball.isExist(name)) {
                        Biathlon.add(name);
                        context.setAttribute("scoreBiathlon", Biathlon.getList().size());
                        context.setAttribute("nameBiathlon", Biathlon.getList());
                        System.out.println(name);
                        session.invalidate();
                        resp.sendRedirect("task2\\vote.jsp");
                    } else {
                        resp.sendRedirect("info.jsp");
                    }
                    break;

                case "Basketball":
                    if (!Football.isExist(name) && !Biathlon.isExist(name) && !Basketball.isExist(name)) {
                        Basketball.add(name);
                        context.setAttribute("scoreBasketball", Basketball.getList().size());
                        context.setAttribute("nameBasketball", Basketball.getList());
                        System.out.println(name);
                        session.invalidate();
                        resp.sendRedirect("task2\\vote.jsp");
                    } else {
                        resp.sendRedirect("info.jsp");
                    }
                    break;
            }
        } else {
            resp.sendRedirect("info.jsp");
        }
    }
}