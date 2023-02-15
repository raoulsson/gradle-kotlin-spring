package com.example.videogames.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.handler.MappedInterceptor

@Configuration
class InterceptorConfig {

    init {
        println("InterceptorConfig initialized")
    }
    @Bean
    @Autowired
    fun mappedInterceptor(devRequestTimeLogger: HandlerInterceptor?): MappedInterceptor {
        return MappedInterceptor(
            arrayOf("/**"),
            arrayOf("/css/**", "/js/**", "/images/**", "/favicon.ico"),
            devRequestTimeLogger!!
        )
    }
}