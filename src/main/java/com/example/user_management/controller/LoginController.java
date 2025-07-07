package com.example.user_management.controller;

import com.example.user_management.dto.LoginRequest;
import com.example.user_management.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> processLogin(@RequestBody LoginRequest loginRequest){
        return loginService.validateCredentials(loginRequest.getUser(),
                loginRequest.getPassword());
    }
}
