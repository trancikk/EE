package cool;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Trancikk on 12.07.2017.
 */
@WebServlet(name = "AsyncServlet", urlPatterns = "/async", asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    final Logger logger = Logger.getLogger(AsyncServlet.class.getName());
    logger.log(Level.INFO, "doGet()");
    final AsyncContext asyncContext = request.startAsync();
    logger.log(Level.INFO, "ac.start()");
    asyncContext.start(new Runnable() {
        @Override
        public void run() {
            logger.log(Level.INFO, "thread");
            try{
                Thread.sleep(10000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
                Logger.getLogger(AsyncServlet.class.getName()).log(Level.SEVERE, null, e);
            }
            try{
                asyncContext.getResponse().getWriter().println("shot timeout");
                asyncContext.complete();
            }
            catch (IOException e){
                Logger.getLogger(AsyncServlet.class.getName()).log(Level.INFO, null,e);
            }
        }
    });
    logger.log(Level.INFO,"left doGet");

    }
}
