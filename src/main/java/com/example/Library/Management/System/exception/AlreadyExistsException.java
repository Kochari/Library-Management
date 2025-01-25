package com.example.Library.Management.System.exception;

public class AlreadyExistsException extends RuntimeException {
    private String message;

    public AlreadyExistsException() {
    }

    public AlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
