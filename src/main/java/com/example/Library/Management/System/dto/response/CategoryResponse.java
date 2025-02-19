package com.example.Library.Management.System.dto.response;

import com.example.Library.Management.System.entity.Book;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryResponse {
    String name;
    String description;
    List<Book> books;
}
