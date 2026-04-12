package com.dhruvaa___.demo;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/Software-engineer")
public class Software1 {

    @GetMapping 
    public List<Software> getEngineers() {
        return List.of(
            new Software(1, "James", List.of("js", "node", "react", "tailwind css")),
            new Software(2, "Jamilah", List.of("java", "spring", "boot", "css"))
        );
    }
}