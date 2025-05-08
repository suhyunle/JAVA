package com.example.jwt.pjt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@RequiredArgsConstructor

public class UserResponseDTO {
    private String email;          // ← 추가
    private String passwd;  
    private String accessToken;
    private String refreshToken;
}
