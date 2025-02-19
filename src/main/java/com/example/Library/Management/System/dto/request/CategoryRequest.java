package com.example.Library.Management.System.dto.request;

import com.example.Library.Management.System.entity.Book;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryRequest {
    String name;
    String description;
    List<Book> books;
}
