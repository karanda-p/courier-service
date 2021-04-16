package ru.itfbgroup.courierservice.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Bean
    public BasicAuthRequestInterceptor basicAuthenticationInterceptor(){
//        return new BasicAuthRequestInterceptor("${app.food-delivery-service.username}"
//                ,"${app.food-delivery-service.password}");
        return new BasicAuthRequestInterceptor("courier"
                ,"password");
    }
}
