package in.dev.gmsk.configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/*do")
public class CorsFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServlet req = (HttpServlet) request;

        System.out.println("CORSFi1ter HTTP Request : " + req.getServletContext());

        ((HttpServletResponse) response).addHeader("Access-control-Allow-origin", "*");
        ((HttpServletResponse) response).addHeader("Access-Control-AIIow-Methods", "GET, OPTIONS, HEAD, PUT , POST");
        ((HttpServletResponse) response).addHeader("Access-Control-AIIow-Headers", "*");
        ((HttpServletResponse) response).addHeader("Server", "Apache/Tomcat9.0.0M18");
        ((HttpServletResponse) response).addHeader("X-Powered-By", "Java");

        chain.doFilter(request, response);
    }
}
