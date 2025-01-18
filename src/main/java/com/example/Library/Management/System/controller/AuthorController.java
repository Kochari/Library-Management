package com.example.Library.Management.System.controller;

import com.example.Library.Management.System.dto.AuthorResponse;
import com.example.Library.Management.System.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    AuthorService authorService;
    @GetMapping
    public String getAllAuthors(Model model) {
        List<AuthorResponse> authors = authorService.getAllAuthors();
        model.addAttribute("authors", authors);
        return "authors";  // Renders authors.html
    }

}
