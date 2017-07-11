package cool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Trancikk on 11.07.2017.
 */
@WebServlet(name = "ConfirmationServlet")
public class ConfirmationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            PrintWriter printWriter;
            List<String> checkedLablels = (List<String>) request.getAttribute("labels");
            response.setContentType("text/html");
            printWriter = response.getWriter();
            printWriter.println("<p>");
            if (checkedLablels != null){
                for (String label : checkedLablels){
                    printWriter.println(label);
                    printWriter.println("</br>");
                }
            }
            else {
                printWriter.println("nothing");
            }
            printWriter.println("</p>");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
