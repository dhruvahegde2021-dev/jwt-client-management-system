package com.dhruvaa___.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cId;

    private String name;
    private String lawyers;

    public Client() {}

    public Client(Long cId,String name, String lawyers) {
        this.cId=cId;
        this.name = name;
        this.lawyers = lawyers;
    }

    public Long getCId() {
        return cId;
    }

    public void setCId(Long cId) {
        this.cId = cId;
    }

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