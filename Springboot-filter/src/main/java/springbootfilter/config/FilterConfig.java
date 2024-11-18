package springbootfilter.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springbootfilter.filter.AuthFilter;
import springbootfilter.filter.CoresFilter;
import springbootfilter.filter.LoggingFilter;
import springbootfilter.filter.RateLimitFilter;

@Component
public class FilterConfig {
//    @Bean
//    public FilterRegistrationBean<RateLimitFilter> AuthFilterFilter() {
//        FilterRegistrationBean<RateLimitFilter> registrationBean = new FilterRegistrationBean();
//        registrationBean.setFilter(new RateLimitFilter());
//        //设置过滤器拦截的URL路径
//        registrationBean.addUrlPatterns("/*");
//        registrationBean.setOrder(1);
//        return registrationBean;
//    }
}
