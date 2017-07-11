package cool;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Trancikk on 11.07.2017.
 */

@WebFilter(filterName = "filterServ", initParams = {
        @WebInitParam(name="param1", value="value1")},
        urlPatterns = "/initserv"
)
public class filterServ  implements Filter{

    private FilterConfig filterConfig;


    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig=filterConfig;
    }



    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.getWriter().println("cool");
        ServletContext servletContext = filterConfig.getServletContext();
        servletContext.log("doFilter:");
        Enumeration<String> initParameterNames = filterConfig.getInitParameterNames();
        String parameterValue;
        String parameterName;
        while (initParameterNames.hasMoreElements()){
            parameterName = initParameterNames.nextElement();
            parameterValue=filterConfig.getInitParameter(parameterName);
            servletContext.log(parameterName + "=" + parameterValue);
        }
        servletContext.log("calling servlet");

    }

    @Override
    public void destroy() {
        filterConfig=null;
    }


}
