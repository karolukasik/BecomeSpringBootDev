package io.datajek.tennisplayerrest;

public class PlayerNotFoundException extends RuntimeException {

    public PlayerNotFoundException(String message) {
        super(message);

    }

}