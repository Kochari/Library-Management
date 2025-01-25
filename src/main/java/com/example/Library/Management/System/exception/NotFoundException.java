package com.example.Library.Management.System.exception;

public class NotFoundException extends RuntimeException {
    private String message;
    public NotFoundException() {}
    public NotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
