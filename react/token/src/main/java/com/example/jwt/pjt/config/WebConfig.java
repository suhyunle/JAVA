package com.example.jwt.pjt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 모든 경로에 대해
                .allowedHeaders("*")  // 모든 요청 헤더 허용
                .allowedOrigins("http://localhost:3000") // React 서버 주소 허용
                .allowedMethods("*")  // 모든 HTTP 메소드 허용 (GET, POST, PUT, DELETE 등)
                .allowCredentials(true)  // 인증정보 포함 허용
                .exposedHeaders("Authorization", "Refresh-Token");  // 노출시킬 헤더 설정
    }
}
