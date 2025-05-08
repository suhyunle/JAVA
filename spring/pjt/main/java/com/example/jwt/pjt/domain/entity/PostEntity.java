package com.example.jwt.pjt.domain.entity;

import com.example.jwt.pjt.dto.PostRequestDTO;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String email;

    public String getEmail(){
        return email;
    }

    // 게시글 수정 로직
    public void updatePost(PostRequestDTO params) {
        this.title = params.getTitle();
        this.content = params.getContent();
    }

    // //게시글 삭제 로직
    // public void deletePost (PostRequestDTO params){
    //     this.title = params.getTitle();
    //     this.content 
    // }
}
