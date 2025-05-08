package com.example.jwt.pjt.ctrl;

import com.example.jwt.pjt.domain.service.AuthService;
import com.example.jwt.pjt.dto.UserRequestDTO;
import com.example.jwt.pjt.dto.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
public class AuthCtrl {

    @Autowired
    private AuthService service;

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody UserRequestDTO params) {
        System.out.println("debug >>>> ctrl login ");
        System.out.println("debug >>>> ctrl login params: " + params);

        UserResponseDTO response = service.loginService(params);

        System.out.println("debug >>>> ctrl login result: " + response);

        return ResponseEntity
                .ok()
                .header("Authorization", "Bearer " + response.getAccessToken())
                .header("Refresh-Token", response.getRefreshToken())
                .body(response);
    }

    @PostMapping("/renew")
    public ResponseEntity<?> renewToken(HttpServletRequest request) {
        System.out.println("debug >>>> ctrl renew");

        String header = request.getHeader("Authorization");
        System.out.println("debug >>>> header Authorization : " + header);

        if (header == null || !header.startsWith("Bearer ")) {
            return ResponseEntity.badRequest().body("Invalid Authorization header");
        }

        String token = header.substring(7);
        System.out.println("debug >>>>> token: " + token);

        try {
            String newAccessToken = service.renewService(token);
            System.out.println("debug >> new access token: " + newAccessToken);

            return ResponseEntity
                    .ok()
                    .header("Authorization", "Bearer " + newAccessToken)
                    .build();

        } catch (Exception e) {
            return ResponseEntity.status(401).body("Token renewal failed: " + e.getMessage());
        }
    }
}
