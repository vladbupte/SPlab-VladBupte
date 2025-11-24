
package ro.uvt.dp.filters;

import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class RequestLoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("[RequestLoggingFilter] Before - " + req.getMethod() + " " + req.getRequestURI());
        chain.doFilter(request, response);
        System.out.println("[RequestLoggingFilter] After - " + req.getMethod() + " " + req.getRequestURI());
    }

    @Override
    public void destroy() {}
}
