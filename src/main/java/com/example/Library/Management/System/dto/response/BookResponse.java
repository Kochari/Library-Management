package com.example.Library.Management.System.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookResponse {
    Long id;
    String name;
    String isbn;
    String description;
    Long stockCount;
    Long categoryId;
    List<Long> authorIds;
}
