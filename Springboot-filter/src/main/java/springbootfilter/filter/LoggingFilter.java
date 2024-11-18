package springbootfilter.filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Component
@Slf4j
public class LoggingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("LoggingFilter 初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;

        String path=request.getRequestURI();
        String clientIp = request.getRemoteAddr();
        LocalDateTime time=LocalDateTime.now();
        log.info("请求代到达滤器，path:{},clientIp{}",path,clientIp);
        filterChain.doFilter(request,servletResponse);
        log.info("过滤器处理之后，时间time:{},path:{}",time,path);
    }

    @Override
    public void destroy() {
        log.info("LoggingFilter 初销毁");
    }
}
