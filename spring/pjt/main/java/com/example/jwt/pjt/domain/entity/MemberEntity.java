package com.example.jwt.pjt.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {

    @Id
    @Column(nullable = false, unique = true)
    private String email;
    private String passwd;


    @Column(name = "refresh_token")
    private String refreshToken;

    /**
     * 회원이 작성한 게시글 리스트
     * - 연관된 게시글(PostEntity)이 MemberEntity 삭제 시 함께 삭제됨 (cascade)
     * - 고아 객체 제거 기능 활성화 (orphanRemoval = true)
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "member_email") // PostEntity의 외래 키 컬럼명
    private List<PostEntity> posts = new ArrayList<>();

        // addPost() 메서드 추가
        public void addPost(PostEntity post) {
            this.posts.add(post); // List에 게시물 추가
        }


        public PostEntity findPost(Long id) { // @@ 추가
            return posts.stream()
                        .filter(post -> post.getId().equals(id))
                        .findFirst()
                        .orElse(null); // 또는 .orElseThrow(...)
        } // @@ 추가
}
