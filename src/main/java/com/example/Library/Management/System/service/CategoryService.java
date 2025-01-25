package com.example.Library.Management.System.service;

import com.example.Library.Management.System.dto.response.BookResponse;
import com.example.Library.Management.System.dto.response.CategoryResponse;
import com.example.Library.Management.System.entity.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAllCategories(int page, int size);
    CategoryResponse getCategoryById(Long id);
   void saveCategory(Category category);
   void updateCategory(Long id, Category category);
   void deleteCategory(Long id);
   List<BookResponse> getAllBooksbyCategoryId(Long id);

}
