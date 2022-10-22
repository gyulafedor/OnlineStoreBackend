package com.example.gyula.fedor.OnlineStore.cartElements;

import com.example.gyula.fedor.OnlineStore.user.Users;
import jakarta.persistence.*;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class CartElements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userEmail;
    private String gameName;
    private String gameDescription;
    private long gamePrice;

    public CartElements() {
    }

    public CartElements(long id, String userEmail, String gameName, String gameDescription, long gamePrice) {
        this.id = id;
        this.userEmail = userEmail;
        this.gameName = gameName;
        this.gameDescription = gameDescription;
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

    public String getGameDescription() {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
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
                ", gameDescription='" + gameDescription + '\'' +
                ", gamePrice=" + gamePrice +
                '}';
    }
}
