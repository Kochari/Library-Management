package com.example.Library.Management.System.service;

public interface AuthService {
    public String register(String username, String password);
    public String authenticate(String username, String password);
}
