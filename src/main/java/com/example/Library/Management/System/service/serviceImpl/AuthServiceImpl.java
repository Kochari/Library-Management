package com.example.Library.Management.System.service.serviceImpl;

import com.example.Library.Management.System.entity.Auth;
import com.example.Library.Management.System.enums.Role;
import com.example.Library.Management.System.repository.AuthRepository;
import com.example.Library.Management.System.security.JwtService;
import com.example.Library.Management.System.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthServiceImpl(AuthRepository authRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public String register(String username, String password) {
        if (authRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("User already exists!");
        }

        Auth newUser = Auth.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .role(Role.USER)
                .build();
        log.info("User registered: {}", newUser.getUsername());
        authRepository.save(newUser);

        return jwtService.generateToken(newUser.getUsername());
    }

    @Override
    public String authenticate(String username, String password) {
        Auth user = authRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password!");
        }

        return jwtService.generateToken(user.getUsername());
    }
}
