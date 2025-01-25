package com.example.Library.Management.System.service;

import com.example.Library.Management.System.dto.response.BookResponse;
import com.example.Library.Management.System.entity.Book;

import java.util.List;

public interface BookService {
    List<BookResponse> getAllBooks();
    BookResponse getBookById(Long id);
    void saveBook(Book book);
    void updateBook(Long id, Book book);
    void deleteBook(Long id);
    List<BookResponse> getBooksByCategory(Long categoryId);
    List<BookResponse> getBooksByAuthorId(Long authorId);

}
