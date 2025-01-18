package com.example.Library.Management.System.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    LocalDate orderDate;
    LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    Student student;
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    Book book;
}