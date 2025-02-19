package com.example.Library.Management.System.controller;

import com.example.Library.Management.System.dto.response.AuthorResponse;
import com.example.Library.Management.System.entity.Author;
import com.example.Library.Management.System.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/authors")
@AllArgsConstructor
public class AuthorController {
    AuthorService authorService;
    @GetMapping
    public String getAllAuthors(Model model,@RequestParam int page,@RequestParam int size) {
        List<AuthorResponse> authors = authorService.getAllAuthors(page, size);
        model.addAttribute("authors", authors);
        return "authors";  // Renders authors.html
    }
    @GetMapping("/{id}")
    public String getAuthorById(@PathVariable Long id, Model model) {
        Author author = authorService.getAuthorById(id);
        model.addAttribute("author", author);
        return "author-details";  // Renders author-details.html
    }
    @PostMapping
    public String createAuthor(@ModelAttribute("author") Author author) {
        authorService.saveAuthor(author);
        return "redirect:/authors";  // Redirect to authors list
    }
    @PostMapping("/update")
    public String updateAuthor(@ModelAttribute Author author) {
        authorService.updateAuthor(author.getId(), author);
        return "redirect:/authors";
    }


    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return "redirect:/authors";
    }
}
