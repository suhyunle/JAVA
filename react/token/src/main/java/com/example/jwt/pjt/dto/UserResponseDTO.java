package com.example.jwt.pjt.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponseDTO {
    private String email;          // ← 추가
    private String passwd;  
    private String accessToken;
    private String refreshToken;
}
