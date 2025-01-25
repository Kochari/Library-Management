package com.example.Library.Management.System.service.serviceImpl;

import com.example.Library.Management.System.dto.response.BookResponse;
import com.example.Library.Management.System.entity.Book;
import com.example.Library.Management.System.exception.BookNotFoundException;
import com.example.Library.Management.System.exception.CategoryNotFoundException;
import com.example.Library.Management.System.mapper.BookMapper;
import com.example.Library.Management.System.repository.BookRepository;
import com.example.Library.Management.System.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public List<BookResponse> getAllBooks() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Book> books = bookRepository.findAll(pageable);
        if (books.isEmpty()) {
            throw new BookNotFoundException("No books found");
        } else {
            return bookRepository
                    .findAll()
                    .stream()
                    .map(bookMapper::bookToBookResponse)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public BookResponse getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new BookNotFoundException("Book not found")
        );
        return bookMapper.bookToBookResponse(book);
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void updateBook(Long id, Book book) {

        Book _book = bookRepository.findById(id).orElseThrow(
                () -> new BookNotFoundException("Book not found")
        );
        _book.setName(book.getName());
        _book.setAuthors(book.getAuthors());
        _book.setIsbn(book.getIsbn());
        _book.setCategory(book.getCategory());
        _book.setDescription(book.getDescription());
        _book.setOrders(book.getOrders());
        bookRepository.save(_book);

    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookResponse> getBooksByCategory(Long categoryId) {
        List<Book> book = bookRepository.findBooksByCategoryId(categoryId);
        if (book.isEmpty()) {
            throw new CategoryNotFoundException("Category not found");
        }
        else {
            return bookRepository
                    .findBooksByCategoryId(categoryId)
                    .stream()
                    .map(bookMapper::bookToBookResponse)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public List<BookResponse> getBooksByAuthorId(Long authorId) {
        List<Book> book = bookRepository.findBooksByAuthorId(authorId);
        if (book.isEmpty()) {
            throw new BookNotFoundException("Book not found");
        }else {
            return bookRepository
                    .findBooksByAuthorId(authorId)
                    .stream()
                    .map(bookMapper::bookToBookResponse)
                    .collect(Collectors.toList());
        }
    }
}
