package couhensoft.velochat;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableTransactionManagement
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/static/webjars/", "classpath:/META-INF/resources/webjars/");
        registry
                .addResourceHandler("/**")
                .addResourceLocations("classpath:/static/", "classpath:/META-INF/resources/");

    }
}
