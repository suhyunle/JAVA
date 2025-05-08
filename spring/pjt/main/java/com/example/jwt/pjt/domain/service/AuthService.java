package com.example.jwt.pjt.domain.service;

import com.example.jwt.pjt.domain.entity.AuthEntity;
import com.example.jwt.pjt.domain.entity.MemberEntity;
import com.example.jwt.pjt.domain.entity.PostEntity;
import com.example.jwt.pjt.domain.util.JwtProvider;
import com.example.jwt.pjt.dto.PostRequestDTO;
import com.example.jwt.pjt.dto.PostResponseDTO;
import com.example.jwt.pjt.dto.UserRequestDTO;
import com.example.jwt.pjt.dto.UserResponseDTO;
import com.example.jwt.pjt.repository.AuthRepository;
import com.example.jwt.pjt.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private JwtProvider provider;

    @Autowired
    private AuthRepository repository;

    @Autowired
    private MemberRepository memberRepository;

    public UserResponseDTO loginService(UserRequestDTO params) {
        System.out.println("debug >>> service login with params: " + params);

        String accessToken = provider.generateAccessToken(params.getEmail());
        String refreshToken = provider.generateReToken(params.getEmail());

        AuthEntity entity = AuthEntity.builder()
                .email(params.getEmail())
                .passwd(params.getPasswd())
                .refreshToken(refreshToken)
                .build();

        repository.save(entity);

        Optional<AuthEntity> op = repository.findByEmail(params.getEmail());
        if (op.isPresent()) {
            AuthEntity result = op.get();
            return UserResponseDTO.builder()
                    .email(result.getEmail())
                    .passwd(result.getPasswd())
                    .refreshToken(result.getRefreshToken())
                    .accessToken(accessToken)
                    .build();
        } else {
            return UserResponseDTO.builder()
                    .accessToken(accessToken)
                    .refreshToken(refreshToken)
                    .build();
        }
    }

    public String renewService(String token) {
        System.out.println("debug >>> service renewService");

        Optional<MemberEntity> op = memberRepository.findByToken(token);
        if (op.isEmpty()) {
            throw new RuntimeException("Invalid or expired refresh token.");
        }

        String email = provider.renewToken(op.get().getRefreshToken());
        return provider.generateAccessToken(email);
    }

    public PostResponseDTO createPostService(String id, PostRequestDTO params) {
        System.out.println("debug >>>> UserService createPostService");

        Optional<MemberEntity> op = memberRepository.findById(id);
        if (op.isPresent()) {
            PostEntity post = PostEntity.builder()
                    .title(params.getTitle())
                    .content(params.getContent())
                    .build();

            op.get().addPost(post);
            memberRepository.save(op.get());

            return PostResponseDTO.builder()
                    .title(params.getTitle())
                    .content(params.getContent())
                    .build();
        } else {
            throw new RuntimeException("Member not found with ID: " + id);
        }
    }
}
