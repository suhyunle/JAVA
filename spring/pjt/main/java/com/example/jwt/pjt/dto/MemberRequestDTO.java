package com.example.jwt.pjt.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberRequestDTO {

   
    private String email;

   
    private String passwd;

    private String refreshToken;
}
