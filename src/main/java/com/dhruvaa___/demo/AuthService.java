package com.dhruvaa___.demo;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository repo;

    public AuthService(UserRepository repo) {
        this.repo = repo;
    }

    public String register(RegisterDTO registerDTO) {

        User existing = repo.findByUsername(registerDTO.getUsername());

        if (existing != null)
            throw new RuntimeException("Username already exists");

        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(registerDTO.getPassword());
        user.setRole("USER");

        repo.save(user);

        return "User registered successfully";
    }

    public String login(LoginDTO dto) {

        User user = repo.findByUsername(dto.getUsername());

        if (user == null)
            throw new RuntimeException("User not found");

        if (user.getPassword().equals(dto.getPassword())) {
            return "TOKEN_GENERATED";
        } else {
            throw new RuntimeException("Invalid Password");
        }
    }
}