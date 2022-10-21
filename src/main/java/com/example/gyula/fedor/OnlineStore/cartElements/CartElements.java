package com.example.gyula.fedor.OnlineStore.cartElements;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CartElements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userEmail;
    private String gameName;
    private long gamePrice;

    public CartElements() {
    }

    public CartElements(long id, String userEmail, String gameName, long gamePrice) {
        this.id = id;
        this.userEmail = userEmail;
        this.gameName = gameName;
        this.gamePrice = gamePrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public long getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(long gamePrice) {
        this.gamePrice = gamePrice;
    }

    @Override
    public String toString() {
        return "CartElements{" +
                "id=" + id +
                ", userEmail='" + userEmail + '\'' +
                ", gameName='" + gameName + '\'' +
                ", gamePrice='" + gamePrice + '\'' +
                '}';
    }
}
