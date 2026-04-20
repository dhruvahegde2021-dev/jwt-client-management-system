package com.dhruvaa___.demo;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository repo, PasswordEncoder encoder, JwtUtil jwtUtil) {
        this.repo = repo;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
    }

    public String register(RegisterDTO registerDTO) {

        User existing = repo.findByUsername(registerDTO.getUsername());

        if (existing != null)
            throw new AppException("Username already exists");

        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(encoder.encode(registerDTO.getPassword()));
        user.setRole("USER");

        repo.save(user);

        return "User registered successfully";
    }

    public String login(LoginDTO dto) {

        User user = repo.findByUsername(dto.getUsername());

        if (user == null)
            throw new AppException("User not found");

        if (encoder.matches((dto.getPassword()),user.getPassword())) {
           String token= jwtUtil.generateToken(user.getUsername());
           String extracted=jwtUtil.extractUsername(token);
           System.out.println("Extracted username:"+extracted);
           return token;
        } else {
            throw new AppException("Invalid Password");
        }
    }
}