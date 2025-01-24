package com.example.Library.Management.System.dto.response;

import com.example.Library.Management.System.entity.Order;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentResponse {
    String firstName;
    String lastName;
    String email;
    String phone;
    String FIN;
    LocalDate registrationDate;
    List<Order> orders;
}
