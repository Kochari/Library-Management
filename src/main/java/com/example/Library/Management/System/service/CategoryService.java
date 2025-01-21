package com.example.Library.Management.System.service;

import com.example.Library.Management.System.dto.AuthorResponse;
import com.example.Library.Management.System.entity.Author;
import com.example.Library.Management.System.entity.Book;
import com.example.Library.Management.System.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
   void saveCategory(Category category);
   void updateCategory(Category category);
   void deleteCategory(Long id);
   List<Book> getAllBooksbyCategoryId(Long id);

}
