package com.dhruvaa___.demo;

public class RegisterDTO {
    private String username;
    private String password;
    public RegisterDTO(){}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
