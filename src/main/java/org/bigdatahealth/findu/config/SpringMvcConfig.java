package org.bigdatahealth.findu.config;

import org.bigdatahealth.findu.interceptor.MyInterceptor;
import org.bigdatahealth.findu.locale.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {


    // 配置拦截器 查验token信息
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/api/**")
                .excludePathPatterns("/api/user/login");
    }


//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("/login");
//        registry.addViewController("/index.html").setViewName("/login");
//    }


//    配置国际化
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }


}
