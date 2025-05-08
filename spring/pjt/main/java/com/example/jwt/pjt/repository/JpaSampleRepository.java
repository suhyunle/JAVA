package com.example.jwt.pjt.repository;

import com.example.jwt.pjt.domain.entity.JpaSampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaSampleRepository extends JpaRepository<JpaSampleEntity, String> {
    // 추가적인 쿼리 메서드를 정의할 수 있습니다.
    // 예: 사용자 ID로 엔티티를 조회하는 메서드
    JpaSampleEntity findByUserId(String userId);
}
