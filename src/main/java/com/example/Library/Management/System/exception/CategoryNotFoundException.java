package com.example.Library.Management.System.exception;

public class CategoryNotFoundException extends RuntimeException {
    private String message;
public CategoryNotFoundException() {}
    public CategoryNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
