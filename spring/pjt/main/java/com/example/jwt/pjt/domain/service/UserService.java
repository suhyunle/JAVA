package com.example.jwt.pjt.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jwt.pjt.domain.entity.MemberEntity;
import com.example.jwt.pjt.domain.entity.PostEntity;
import com.example.jwt.pjt.dto.PostRequestDTO;
import com.example.jwt.pjt.repository.MemberRepository;

@Service
public class UserService {

    @Autowired
    private MemberRepository memberRepository;
    // getUserPostService 메서드 수정 (이메일을 사용)
    public List<PostRequestDTO> getUserPostService(String email) {
        System.out.println("debug>>> userservice getUser with email: " + email);
        
        // 이메일로 사용자 찾기
        Optional<MemberEntity> op = memberRepository.findById(email);

        // 회원이 존재하면 그 회원의 게시물 목록 반환, 없으면 빈 리스트 반환
        return op.map(member -> member.getPosts().stream()
                .map(post -> PostRequestDTO.builder()
                        .title(post.getTitle())
                        .content(post.getContent())
                        .build())
                .collect(Collectors.toList()))
            .orElseGet(List::of); // 회원이 없으면 빈 리스트 반환
    }

    public void updatePostService(String email, PostRequestDTO params) {
        System.out.println("debug >>>> UserService updatePostService");
        System.out.println("debug >>>> execute query 1.");

        MemberEntity member = memberRepository.findById(email)
                .orElseThrow(() -> new RuntimeException("not found"));

        System.out.println("debug >>>> execute query 2.");

        PostEntity post = member.findPost(params.getId()); // 이 메서드는 사용자 정의 메서드로 가정
        if (post == null) {
            throw new RuntimeException("Post not found for given ID");
        }

        System.out.println("debug >>>> execute query 3.");

        post.updatePost(params); // 게시글 내용 수정

        System.out.println("debug >>>> post updated successfully.");
    }

    // public void deletePostService(String email, String postId) {
    //     Long id = Long.parseLong(postId); // String → Long 형변환
    //     Optional<PostEntity> postOptional = postRepository.findById(id);

    //     if (postOptional.isEmpty()){
    //         throw new IllegalArgumentException("게시글이 존재하지 않습니다");
    //     }

    //     PostEntity post = postOptional.get();
    //     //이메일이 일치하는 지 확인
    //     if(!post.getEmail().equals(email)){
    //         throw new SecurityException("삭제 권한이 없습니다. ");
    //     }
    //     //삭제
    //     postRepository.delete(post);
    //     //로그 출력 
    //     System.out.println("게시글이 삭제되었습니다. postId=" +postId +", email" +email);

    // }

    
    public void deletePostService(String email, Long postId) {
        System.out.println("debug >>>> UserService deletePostService");
    
        // 1. 이메일로 회원을 찾는다
        System.out.println("debug >>>> execute query 1.");
        MemberEntity member = memberRepository.findById(email)
            .orElseThrow(() -> new RuntimeException("Member not found"));
    
        // 2. 해당 회원의 포스트 목록에서 postId에 해당하는 포스트를 찾는다
        System.out.println("debug >>>> execute query 2.");
        PostEntity p = member.getPosts().stream()
            .filter(post -> post.getId().equals(postId))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Post not found"));
    
        // 3. 포스트 찾았으면, 그 포스트를 삭제한다
        System.out.println("debug >>>> execute query 3.");
        member.getPosts().remove(p);
    }

}
    



