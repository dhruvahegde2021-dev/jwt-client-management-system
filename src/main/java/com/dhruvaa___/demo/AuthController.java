package com.dhruvaa___.demo;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {

        private final AuthService service;

        public AuthController(AuthService service) {
            this.service = service;
        }

        @PostMapping("/register")
        public ResponseEntity<String> register(@Valid @RequestBody RegisterDTO registerDTO)
        {
            return ResponseEntity.ok(service.register(registerDTO));
        }

        @PostMapping("/login")
        public ResponseEntity<String> login(@Valid @RequestBody LoginDTO dto)
        {
            return ResponseEntity.ok(service.login(dto));
        }
    }
