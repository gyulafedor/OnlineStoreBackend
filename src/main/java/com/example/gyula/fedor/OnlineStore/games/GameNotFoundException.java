package com.example.gyula.fedor.OnlineStore.games;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class GameNotFoundException extends Throwable {
    public GameNotFoundException(String message) {
        super(message);
    }
}
