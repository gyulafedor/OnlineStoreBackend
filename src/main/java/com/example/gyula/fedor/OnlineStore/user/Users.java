package com.example.gyula.fedor.OnlineStore.user;

import com.example.gyula.fedor.OnlineStore.cartElements.CartElements;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
public class Users {

    @Id
    @Email
    private String email;

    private String name;

    private String password;

    public Users() {
    }

    public Users(String email, String name, String password) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Users{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
