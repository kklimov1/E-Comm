package com.example.ECommerce.exceptions;

public class UsernameTakenException extends Exception{
    public UsernameTakenException(String message) {
        super(message);
    }
}
