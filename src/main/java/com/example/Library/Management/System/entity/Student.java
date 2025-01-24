package com.example.Library.Management.System.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;
     String firstName;
     String lastName;
     String email;
     String phone;
     String FIN;
     LocalDate registrationDate;
    @OneToMany(mappedBy = "student")
    List<Order> orders;
}
