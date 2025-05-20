package com.example.backend.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.backend.domain.entity.UserRequestDTO;
import com.example.backend.domain.entity.UserResponseDTO;

@Mapper
public interface UserMapper {
    UserResponseDTO signIn(@Param("id") String id, @Param("pwd") String pwd);
    void signup(UserRequestDTO userRequestDTO);
}
