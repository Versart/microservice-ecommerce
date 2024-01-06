package br.com.ecommerce.auth.domain.service;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.ecommerce.auth.api.model.LoginRequest;
import br.com.ecommerce.auth.api.model.TokenResponse;
import br.com.ecommerce.auth.api.model.UserRequest;
import br.com.ecommerce.auth.api.model.UserResponse;
import br.com.ecommerce.auth.domain.model.User;
import br.com.ecommerce.auth.domain.model.UserRole;
import br.com.ecommerce.auth.domain.repository.UserRepository;
import br.com.ecommerce.auth.security.TokenService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final TokenService tokenService;

    private final ModelMapper mapper;

    private final AuthenticationManager authenticationManager;
    
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserResponse register(UserRequest userRequest) {
        logger.info("Creating new user");
        User user = mapper.map(userRequest, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUserRole(UserRole.USER);
        return mapper.map(userRepository.save(user), UserResponse.class);
    }

    public TokenResponse getToken(LoginRequest loginRequest) {
        logger.info("Generating token");
        var userNamePassword = new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), 
            loginRequest.getPassword());
        var auth = authenticationManager.authenticate(userNamePassword);
        String token = tokenService.getToken((User) auth.getPrincipal());
        return new TokenResponse(token);
    }
}
