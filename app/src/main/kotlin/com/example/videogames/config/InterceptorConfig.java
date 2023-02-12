package com.example.videogames.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.MappedInterceptor;

@Configuration
public class InterceptorConfig {
    @Bean
    @Autowired
    public MappedInterceptor mappedInterceptor(HandlerInterceptor requestTimeLogger) {
        return new MappedInterceptor(new String[]{"/**"}, new String[]{"/css/**", "/js/**", "/images/**", "/favicon.ico"}, requestTimeLogger);
    }
}