package br.com.ecommerce.auth.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.auth.api.model.LoginRequest;
import br.com.ecommerce.auth.api.model.TokenResponse;
import br.com.ecommerce.auth.api.model.UserRequest;
import br.com.ecommerce.auth.api.model.UserResponse;
import br.com.ecommerce.auth.domain.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    
    private final UserService userService;

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody UserRequest userRequest){
        logger.info("Received request to save new user");
        return new ResponseEntity<>(userService.register(userRequest),HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@Valid @RequestBody LoginRequest loginRequest){
        logger.info("Received request to authenticate");
        return ResponseEntity.ok(userService.getToken(loginRequest));

    }

}
