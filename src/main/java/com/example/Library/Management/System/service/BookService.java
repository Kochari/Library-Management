package com.example.Library.Management.System.service;

import com.example.Library.Management.System.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    void saveBook(Book book);
    void updateBook(Book book);
    void deleteBook(Long id);
    List<Book> getBooksByCategory(Long categoryId);
    List<Book> getBooksByAuthorId(Long authorId);

}
