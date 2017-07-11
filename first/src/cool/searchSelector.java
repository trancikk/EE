package cool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Trancikk on 11.07.2017.
 */
@WebServlet(name = "searchSelector")
public class searchSelector extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getParameter("selector");
        if (url != null){
            response.sendRedirect(url);
        }
        else {
            PrintWriter printWriter = response.getWriter();
            printWriter.println("cool");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
