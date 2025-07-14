package com.example.user_management.service;

import com.example.user_management.dto.LoginResponse;
import com.example.user_management.entity.UserApp;
import com.example.user_management.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<LoginResponse> validateCredentials(String user, String password){
        Optional<UserApp> userOptional = userRepository.findByUsername(user);

        if(userOptional.isPresent()) {
            UserApp savedUserApp = userOptional.get();
            if(savedUserApp.getPassword().equals(password)){
                return new ResponseEntity<>(new LoginResponse("Login Successful"), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new LoginResponse("Wrong Credentials"),HttpStatus.UNAUTHORIZED);
            }
        } else {
            return new ResponseEntity<>(new LoginResponse("Wrong Credentials"),HttpStatus.UNAUTHORIZED);
        }
    }
}
