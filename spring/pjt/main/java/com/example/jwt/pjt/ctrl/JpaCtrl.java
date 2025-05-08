package com.example.jwt.pjt.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.jwt.pjt.domain.entity.JpaSampleEntity;
import com.example.jwt.pjt.repository.JpaSampleRepository;

import java.util.Map;

@RestController
@RequestMapping("/jpa")
public class JpaCtrl {

    @Autowired
    private JpaSampleRepository jpaSampleRepository;

    @PostMapping("/sign-up")
    public JpaSampleEntity signup(@RequestBody Map<String, Object> params) {
        System.out.println("debug >>> signup");

        JpaSampleEntity entity = JpaSampleEntity.builder()
                .userId((String) params.get("userId"))
                .passwd((String) params.get("passwd"))
                .name((String) params.get("name"))
                .point((Integer) params.get("point"))
                .build();

        jpaSampleRepository.save(entity);
        return entity;
    }
}
