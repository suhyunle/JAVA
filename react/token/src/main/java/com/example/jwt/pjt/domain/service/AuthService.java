package com.example.jwt.pjt.domain.service;

import com.example.jwt.pjt.domain.entity.AuthEntity;
import com.example.jwt.pjt.domain.util.JwtProvider;
import com.example.jwt.pjt.dto.UserRequestDTO;
import com.example.jwt.pjt.dto.UserResponseDTO;
import com.example.jwt.pjt.repository.AuthRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JwtProvider provider; 

    @Autowired
    private AuthRepository repository;

    public UserResponseDTO loginService(UserRequestDTO params) {
        System.out.println("debug >>> service login with params: " + params);

       
        String accToken = provider.generateAccessToken(params.getEmail());
        String refToken = provider.generateReToken(params.getEmail());

       
        AuthEntity entity = AuthEntity.builder()
                .email(params.getEmail())
                .passwd(params.getPasswd())
                .refreshToken(refToken)
                .build();


        repository.save(entity);

        Optional<AuthEntity> op = repository.findByEmail(params.getEmail()); 
        if (op.isPresent()) {
            AuthEntity result = op.get();
            UserResponseDTO response = UserResponseDTO.builder()
                .email(result.getEmail())  // 이메일을 응답에 포함
                .passwd(result.getPasswd()) // 실제 비밀번호를 반환 (다만 비밀번호는 보통 응답에서 반환하지 않습니다)
                .refreshToken(result.getRefreshToken()) // 리프레시 토큰을 응답에 포함
                .accessToken(accToken)  // 생성한 액세스 토큰을 응답에 포함
                .build();
            return response;  // 응답 반환
        } else {
            // 사용자가 존재하지 않으면 새로운 엔티티 생성
            AuthEntity newEntity = AuthEntity.builder()
                .email(params.getEmail())  // 이메일
                .passwd(params.getPasswd()) // 비밀번호
                .refreshToken(refToken)    // 리프레시 토큰
                .build();
            
            repository.save(newEntity); // 새로운 엔티티를 DB에 저장
        
            return UserResponseDTO.builder() 
                .accessToken(accToken)  // 생성한 액세스 토큰 반환
                .refreshToken(refToken)  // 생성한 리프레시 토큰 반환
                .build();
        }
}
}
