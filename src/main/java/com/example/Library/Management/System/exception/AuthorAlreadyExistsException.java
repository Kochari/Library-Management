package com.example.Library.Management.System.exception;

public class AuthorAlreadyExistsException extends RuntimeException {
    private String message;

    public AuthorAlreadyExistsException() {
    }

    public AuthorAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
