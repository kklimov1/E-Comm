package com.example.ECommerce.exceptions;

public class IncorrectLoginRequest extends Exception{
    public IncorrectLoginRequest(String message) {
        super(message);
    }
}
