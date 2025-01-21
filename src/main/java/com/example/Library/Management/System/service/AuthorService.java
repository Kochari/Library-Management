package com.example.Library.Management.System.service;

import com.example.Library.Management.System.dto.AuthorResponse;
import com.example.Library.Management.System.entity.Author;
import com.example.Library.Management.System.entity.Book;

import java.util.List;

public interface AuthorService {
    List<AuthorResponse> getAllAuthors();
    Author getAuthorById(Long id);
    void saveAuthor(Author author);
    void updateAuthor(Long id, Author author);
    void deleteAuthor(Long id);
    List<Book> getAllBooksByAuthorId(Long id);

}
