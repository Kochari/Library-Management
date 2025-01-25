package com.example.Library.Management.System.exception;

public class BookNotFoundException extends RuntimeException {
    private String message;

    public BookNotFoundException() {
    }

    public BookNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
