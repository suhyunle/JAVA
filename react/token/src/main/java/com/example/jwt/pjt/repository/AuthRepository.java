package com.example.jwt.pjt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jwt.pjt.domain.entity.AuthEntity;

@Repository
public interface AuthRepository extends JpaRepository<AuthEntity, Long> {
    // 추가: username으로 회원 조회하는 기능 만들 수 있음
    AuthEntity findByUsername(String username);
      // 이메일로 사용자 찾기
      Optional<AuthEntity> findByEmail(String email);
}

//사용자 정의에 메서드를 추가하는 것도 가능. 




