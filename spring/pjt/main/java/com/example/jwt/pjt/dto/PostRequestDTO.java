package com.example.jwt.pjt.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostRequestDTO {
    private Long Id;
    private String title;
    private String content;
}
