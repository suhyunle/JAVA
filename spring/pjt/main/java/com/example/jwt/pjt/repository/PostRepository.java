package com.example.jwt.pjt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jwt.pjt.domain.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    // 기본 CRUD 메서드는 JpaRepository가 제공
    // 필요한 경우 커스텀 메서드 추가 가능
}

