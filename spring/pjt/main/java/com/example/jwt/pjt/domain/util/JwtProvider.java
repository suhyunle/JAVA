package com.example.jwt.pjt.domain.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;



@Component
public class JwtProvider {

    @Value("${jwt.secret}")
    private String secret; // application.yml 에서 가져옴

    // JWT 서명용 Key 가져오기
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    // Access Token 생성 메소드
    public String generateAccessToken(String email) {
        System.out.println("debug >>> JwtProvider access token generate");

        long now = System.currentTimeMillis();
        long expirationTime = 1000 * 60 * 60; // 1시간 유효 (1시간 = 3600초)

        return Jwts.builder()
                .setSubject(email)                     // 토큰 제목(Subject)
                .setIssuedAt(new Date(now))             // 토큰 발급 시간
                .setExpiration(new Date(now + expirationTime)) // 만료 시간
                .signWith(getSigningKey(), SignatureAlgorithm.HS256) // 서명(Signature)
                .compact();                             // 토큰 완성
    }

    //  Refresh Token 생성 메소드 (1주일 유효)
    public String generateReToken(String email) {
        System.out.println("debug >>> JwtProvider refresh token generate");

        long now = System.currentTimeMillis();
        long expirationTime = 1000L * 60 * 60 * 24 * 7; // 1주일

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + expirationTime))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }


    //JWT 토큰을 파싱해서 그안에 포함된 사용자 정보 추출, refresh token 갱신할때 사용할 수 있는 메서등
    public String renewToken(String token){
        System.out.println("debug>>>");

        return Jwts.parserBuilder() 
                    .setSigningKey(getSigningKey())
                    .build().parseClaimsJws(token)
                    .getBody()
                    .getSubject();
    }
}
