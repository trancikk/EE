package cool;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Trancikk on 11.07.2017.
 */
@WebServlet(name = "InitServlet", urlPatterns = "/initserv",
initParams = {
        @WebInitParam(name = "param1", value="value1"),
        @WebInitParam(name = "param2", value = "value2")}
)
public class InitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();
        String param1Val = servletConfig.getInitParameter("param1");
        String param2Val = servletConfig.getInitParameter("param2");
        response.setContentType("text/html");
        response.getWriter().println("ololo");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("param1="+param1Val+"\n");
        printWriter.println("param2="+param2Val+"\n");
    }
}
