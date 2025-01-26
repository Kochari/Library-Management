package com.example.Library.Management.System.controller;

import com.example.Library.Management.System.dto.response.BookResponse;
import com.example.Library.Management.System.entity.Book;
import com.example.Library.Management.System.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
    BookService bookService;

    @GetMapping
    public String getAllBooks(Model model, @RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "10") int size) {
        List<BookResponse> books = bookService.getAllBooks(page, size);
        model.addAttribute("books", books);
        return "books";

    }
    @GetMapping("/{id}")
    public String getBookById(@PathVariable Long id, Model model) {
        BookResponse book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "books/details";
    }
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new Book());
        return "books/create"; // Thymeleaf template for creating a book
    }
    @PostMapping
    public String saveBook(@ModelAttribute Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute Book book) {
        bookService.updateBook(id, book);
        return "redirect:/books";
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
    @GetMapping("/category/{categoryId}")
    public String getBooksByCategory(@PathVariable Long categoryId, Model model) {
        List<BookResponse> books = bookService.getBooksByCategory(categoryId);
        model.addAttribute("books", books);
        return "books/list";
    }

    @GetMapping("/author/{authorId}")
    public String getBooksByAuthor(@PathVariable Long authorId, Model model) {
        List<BookResponse> books = bookService.getBooksByAuthorId(authorId);
        model.addAttribute("books", books);
        return "books/list";
    }

}
