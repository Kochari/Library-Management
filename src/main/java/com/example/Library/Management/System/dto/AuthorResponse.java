package com.example.Library.Management.System.dto;

import com.example.Library.Management.System.entity.Book;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AuthorResponse {
    private Long Id;
    private String FirstName;
    private String LastName;
    LocalDate birthDate;
    private String about;
    List<Book> books;
}

