package com.dhruvaa___.demo;
import jakarta.validation.constraints.NotBlank;
public class ClientDTO {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Lawyers cannot be empty")
    private String lawyers;

    public ClientDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLawyers() {
        return lawyers;
    }

    public void setLawyers(String lawyers) {
        this.lawyers = lawyers;
    }
}
