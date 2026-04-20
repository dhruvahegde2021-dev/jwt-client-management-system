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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Client() {
    }

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
