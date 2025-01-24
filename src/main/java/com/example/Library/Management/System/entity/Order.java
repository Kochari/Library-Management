package com.example.Library.Management.System.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;
    LocalDate orderDate;
    LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    Student student;
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    Book book;
}