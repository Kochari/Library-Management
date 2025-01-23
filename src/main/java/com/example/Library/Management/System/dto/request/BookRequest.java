package com.example.Library.Management.System.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookRequest {
    @NotBlank(message = "Add unique book name")
    String name;
    @NotBlank(message = "isbn should be number and alphabet")
    String isbn;
    @NotBlank(message = "Enter available book count")
    Long stockCount;
    @Size(message = "Up to 200 simvol", max = 200)
    String description;
    @NotNull(message = "categoryId must not be null")
    @NotEmpty(message = "categoryId must not be empty")
    Long categoryId;
    @NotNull(message = "authorId must not be null")
    @NotEmpty(message = "authorId must not be empty")
    List<Long> authorId;


}
