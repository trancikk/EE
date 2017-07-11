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
@WebServlet(name = "formHandler")
public class formHandler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value;
        String[] options = request.getParameterValues("box");
        value = request.getParameter("value");

        response.setContentType("text/html");
        PrintWriter printWriter;
        try{
            printWriter = response.getWriter();
            printWriter.println("<h1>");
            printWriter.println("yohoho:");
            printWriter.println(value);
            printWriter.println("</h1>");
            printWriter.println("</br>");
            if (null != options) {
                for (String option : options) {
                    printWriter.println(option);
                    printWriter.println("</br>");
                }
            }
            printWriter.println("");

        }
        catch (IOException e){
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
