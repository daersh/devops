package com.ohgiraffers.bootproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
    *  Rest-API 서버측에서 CORS 처리를 위한 설정 클래스이다.
* */

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                        "*"
        //                추후 docker 포트 맞춰서 할 것
                        ,"http://localhost:8011"
                )
//                특정 포트들만 추가할 시!!!@!@!@!@
//               .allowedOrigins(
//                          "http://localhost:5173",
//                          "http://localhost:8011",
//                          "http://localhost:5173"
//               )
                .allowedMethods("GET","POST","PUT","DELETE")
                .allowedHeaders("Authorization", "Content-Type")
                .exposedHeaders("Custom-Header")
                .allowCredentials(false)
                .maxAge(3600);
    }
}
