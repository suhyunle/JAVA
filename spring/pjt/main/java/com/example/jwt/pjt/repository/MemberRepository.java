package com.example.jwt.pjt.repository;

import com.example.jwt.pjt.domain.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {

    // refreshToken으로 사용자 찾기
    Optional<MemberEntity> findByRefreshToken(String refreshToken);

    // AuthService에서 사용 중인 findByToken() 메서드 (실제 구현은 위 메서드 기반)
    default Optional<MemberEntity> findByToken(String token) {
        return findByRefreshToken(token);
    }
}
