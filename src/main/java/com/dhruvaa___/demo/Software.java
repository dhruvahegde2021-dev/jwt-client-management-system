package com.dhruvaa___.demo;

import java.util.List;

public class Software {
    private Integer id;
    private String name; 
    private List<String> techStack;

    public Software() {}

    public Software(Integer id, String name, List<String> techStack) {
        this.id = id;
        this.name = name;
        this.techStack = techStack;
    }


    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<String> getTechStack() { return techStack; }
    public void setTechStack(List<String> techStack) { this.techStack = techStack; }
}