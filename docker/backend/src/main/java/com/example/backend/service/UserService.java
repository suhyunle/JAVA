package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.dao.UserMapper;
import com.example.backend.domain.entity.UserRequestDTO;
import com.example.backend.domain.entity.UserResponseDTO;

@Service
public class UserService {

    private final UserMapper userMapper;


    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserResponseDTO signIn(String id, String pwd) {
        return userMapper.signIn(id, pwd);
    }

    public void signup(UserRequestDTO userRequestDTO) {
        userMapper.signup(userRequestDTO);
    }
}
