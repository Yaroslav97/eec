package ua.nure.poliakov.Practice9.task1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/call")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer input1 = Integer.parseInt(req.getParameter("firstN"));
        Integer input2 = Integer.parseInt(req.getParameter("secondN"));
        String operation = req.getParameter("operation");

        PrintWriter out = resp.getWriter();

        Integer resultP = input1 + input2;
        Integer resultM = input1 - input2;

        HttpSession session = req.getSession();

        switch (operation.charAt(0)) {
            case '+':
                if (!input1.equals(null) && !input2.equals(null)) {
                    System.out.printf("%d + %d = %d", input1, input2, resultP);
                    session.setAttribute("result", resultP);
                    out.print("result - " + resultP);
                    resp.sendRedirect("task1\\calculator.jsp");
                }
                break;

            case '-':
                System.out.printf("%d - %d = %d", input1, input2, resultM);
                session.setAttribute("result", resultM);
                out.print("result - " + resultM);
                resp.sendRedirect("task1\\calculator.jsp");
                break;
        }
    }
}