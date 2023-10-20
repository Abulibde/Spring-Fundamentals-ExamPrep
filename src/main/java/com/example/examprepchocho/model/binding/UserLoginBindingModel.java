package com.example.examprepchocho.model.binding;

import jakarta.validation.constraints.Size;

public class UserLoginBindingModel {

    @Size(min = 5, max = 20)
    private String username;


    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}