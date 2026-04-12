package com.dhruvaa___.demo;


import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/engineers")
public class SoftwareEngineerController {
    private final SoftwareServices service;

    public SoftwareEngineerController(SoftwareServices service) {
        this.service = service;
    }

    @GetMapping
    public List<SoftwareEngineer> getEngineers(){

        return service.getEngineer();
    }

    @PostMapping
    public String addEngineer(@RequestBody SoftwareEngineer engineer)
    {

        return "Received:" + engineer.getName();
    }
}
