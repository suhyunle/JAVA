package com.example.jwt.pjt.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberResponseDTO {

    private String email;
    private String refreshToken;

    // 게시글 제목 목록 등 확장 가능
    // private List<String> postTitles;
}
