package com.example.Library.Management.System.dto.response;

import com.example.Library.Management.System.entity.Book;
import com.example.Library.Management.System.entity.Student;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponse {

    LocalDate orderDate;
    LocalDate returnDate;
    Student student;
    Book book;
}
