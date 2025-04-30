package com.example.jwt.pjt.domain.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;



import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Key;

@Component
public class JwtFilter implements Filter {

    // Secret Key (32바이트 이상)
    private static final String SECRET_KEY = "your-256-bit-secret-your-256-bit-secret";

    // Key 생성
    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

    public Key getKey() {
        return key;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        System.out.println("debug >>> filter");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String method = req.getMethod();
        System.out.println("debug >>> client method: " + method);

        // 1. 프리플라이트 요청 OPTIONS 처리
        if ("OPTIONS".equalsIgnoreCase(method)) {
            res.setStatus(HttpServletResponse.SC_OK);
            res.setHeader("Access-Control-Allow-Origin", "*");
            res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
            res.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
            chain.doFilter(request, response);
            return;
        }

        // 2. JWT 토큰 검증
        String authHeader = req.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            System.out.println("debug >>> 토큰 없음 또는 형식 오류");
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        String token = authHeader.substring(7); // "Bearer " 이후 토큰
        System.out.println("debug >>> token: " + token);

        try {
            // 토큰 검증
            Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);

            System.out.println("debug >>> 토큰 검증 성공 -> 컨트롤러로 이동");
            chain.doFilter(request, response);

        } catch (Exception e) {
            System.out.println("debug >>> 토큰 검증 실패: " + e.getMessage());
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
