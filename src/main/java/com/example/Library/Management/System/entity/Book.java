package com.example.Library.Management.System.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String isbn;
    String description;
    Long stockCount;
    @ManyToMany(mappedBy = "books")
    List<Author> authors;
    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "id")
    Category category;
    @OneToMany(mappedBy = "book")
    List<Order> orders;
}