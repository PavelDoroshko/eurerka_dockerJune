package com.example.log.starter.autoconfigure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class LoggingAutoConfiguration {
    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter(){
        return new CommonsRequestLoggingFilter();
    }
}
