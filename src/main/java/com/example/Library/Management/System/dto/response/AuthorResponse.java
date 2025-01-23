package com.example.Library.Management.System.dto.response;

import com.example.Library.Management.System.entity.Book;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorResponse {
    Long Id;
    String FirstName;
    LocalDate birthDate;
    String about;
    List<Book> books;
}

