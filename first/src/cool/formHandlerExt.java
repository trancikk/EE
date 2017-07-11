package cool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Trancikk on 11.07.2017.
 */
@WebServlet(name = "formHandlerExt")
public class formHandlerExt extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value;
        String[] options;
        options = request.getParameterValues("box");
        value = request.getParameter("value");
        ArrayList<String> selectedLabels = null;
        if (options != null){
             selectedLabels = new ArrayList<String>(options.length);
            for (String label : options){
                if (label.equals("1")) {
                    selectedLabels.add("1");
                }
                if (label.equals("22")) {
                    selectedLabels.add("2");
                }
                if (label.equals("333")) {
                    selectedLabels.add("3");
                }
            }

        }
        selectedLabels.add("cool");
        response.setContentType("text/html");
        PrintWriter printWriter;
        /**try{
            printWriter = response.getWriter();
            printWriter.println("<h1>");
            printWriter.println("yohoho:");
            printWriter.println(value);
            printWriter.println("</h1>");
            printWriter.println("</br>");
            if (null != selectedLabels) {
                for (String option : selectedLabels) {
                    printWriter.println(option);
                    printWriter.println("</br>");
                }
            }
            printWriter.println("");

        }
        catch (IOException e){
            e.printStackTrace();
        }*/
        request.setAttribute("labels", selectedLabels );
        printWriter = response.getWriter();
        printWriter.println("cool");
        try{
            request.getRequestDispatcher("ConfirmationServlet").forward(request,response);
        }
        catch (ServletException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
