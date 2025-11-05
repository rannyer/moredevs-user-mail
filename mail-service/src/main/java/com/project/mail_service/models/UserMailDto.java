package com.project.mail_service.models;

import java.io.Serializable;


public class UserMailDto implements Serializable {
    private String email;
    private String name;
    private Long id;

    public UserMailDto() {
    }

    public UserMailDto(String email, String name, Long id) {
        this.email = email;
        this.name = name;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
