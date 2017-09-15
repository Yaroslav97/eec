package ua.nure.poliakov.SummaryTask4.logic;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lang")
public class I18n extends HttpServlet {

    private static final Logger log = Logger.getLogger(I18n.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lang = req.getParameter("lang");
        req.getSession().setAttribute("lang", lang);
        log.info("Language ==> " + lang);
        resp.sendRedirect("/index");
    }
}
