package springbootfilter.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springbootfilter.filter.LoggingFilter;
import springbootfilter.interceptor.AuthInterceptor;
import springbootfilter.interceptor.CoresFilter;
import springbootfilter.interceptor.Logininterceptor;
import springbootfilter.interceptor.UploadInterceptor;

@Configuration
@AllArgsConstructor

public class InterceptorConfig implements WebMvcConfigurer {
    private final Logininterceptor logininterceptor;
    private final AuthInterceptor authInterceptor;
    private final CoresFilter coresFilter;
    private final UploadInterceptor uploadInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(logininterceptor).addPathPatterns("/**");
//        registry.addInterceptor(coresFilter).addPathPatterns("/**");
//       registry.addInterceptor(authInterceptor).addPathPatterns("/**");
     registry.addInterceptor(uploadInterceptor).addPathPatterns("/**");


    }
}
