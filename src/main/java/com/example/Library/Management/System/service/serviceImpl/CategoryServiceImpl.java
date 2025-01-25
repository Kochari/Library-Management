package com.example.Library.Management.System.service.serviceImpl;

import com.example.Library.Management.System.dto.response.BookResponse;
import com.example.Library.Management.System.dto.response.CategoryResponse;
import com.example.Library.Management.System.entity.Book;
import com.example.Library.Management.System.entity.Category;
import com.example.Library.Management.System.exception.NotFoundException;
import com.example.Library.Management.System.mapper.BookMapper;
import com.example.Library.Management.System.mapper.CategoryMapper;
import com.example.Library.Management.System.repository.BookRepository;
import com.example.Library.Management.System.repository.CategoryRepository;
import com.example.Library.Management.System.service.CategoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryServiceImpl implements CategoryService {

    final CategoryRepository categoryRepository;
    final CategoryMapper categoryMapper;
    final BookRepository bookRepository;
    final BookMapper bookMapper;

    @Override
    public List<CategoryResponse> getAllCategories(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Category> category = categoryRepository.findAll(pageable);
        if (category.isEmpty()) {
            throw new NotFoundException("Category not found");
        } else {
            return categoryRepository
                    .findAll()
                    .stream()
                    .map(categoryMapper::categoryToCategoryResponse)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public CategoryResponse getCategoryById(Long id) {
        return categoryMapper.categoryToCategoryResponse(categoryRepository.getOne(id));
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(Long id, Category category) {
        Category _category = categoryRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Category not found")
        );
        _category.setName(category.getName());
        _category.setDescription(category.getDescription());
        _category.setBooks(category.getBooks());

    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<BookResponse> getAllBooksbyCategoryId(Long id) {
        List<Book> books = bookRepository.findBooksByCategoryId(id);
        if (books.isEmpty()) {
            throw new NotFoundException("Book(s) not found");
        }
        return bookRepository
                .findBooksByAuthorId(id)
                .stream()
                .map(bookMapper::bookToBookResponse)
                .collect(Collectors.toList());
    }
}
