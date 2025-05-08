package com.example.jwt.pjt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@ToString



public class PostResponseDTO {

    

    private Long id;
    private String title;
    private String content;

    // 작성자 이메일이나 닉네임 추가도 가능
    private String writerEmail;
}
