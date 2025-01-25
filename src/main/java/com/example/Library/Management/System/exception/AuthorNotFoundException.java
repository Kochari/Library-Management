package com.example.Library.Management.System.exception;

public class AuthorNotFoundException extends RuntimeException {
    private String message;
    public AuthorNotFoundException() {}
    public AuthorNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
