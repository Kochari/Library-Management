package com.example.Library.Management.System.service.serviceImpl;

import com.example.Library.Management.System.dto.response.AuthorResponse;
import com.example.Library.Management.System.dto.response.BookResponse;
import com.example.Library.Management.System.entity.Author;
import com.example.Library.Management.System.exception.NotFoundException;
import com.example.Library.Management.System.mapper.AuthorMapper;
import com.example.Library.Management.System.mapper.BookMapper;
import com.example.Library.Management.System.repository.AuthorRepository;
import com.example.Library.Management.System.service.AuthorService;
import lombok.RequiredArgsConstructor;
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
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;
    private final BookMapper bookMapper;

    @Override
    public List<AuthorResponse> getAllAuthors(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Author> authors = authorRepository.findAll(pageable);
        if (authors.isEmpty()) {
            throw new NotFoundException("No authors found");
        } else {
            return authorRepository
                    .findAll()
                    .stream()
                    .map(authorMapper::authorToResponse)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Author not found")
        );
    }

    @Override
    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void updateAuthor(Long id, Author author) {
        Author existingAuthor = getAuthorById(id);
        existingAuthor.setFirstName(author.getFirstName());
        existingAuthor.setLastName(author.getLastName());
        existingAuthor.setBirthDate(author.getBirthDate());
        existingAuthor.setAbout(author.getAbout());
        authorRepository.save(existingAuthor);
    }

    @Override
    public void deleteAuthor(Long id) {

        authorRepository.deleteById(id);
    }

    @Override
    public List<BookResponse> getAllBooksByAuthorId(Long id) {
Author author = authorRepository.findById(id).orElseThrow(NotFoundException::new);
if (author.getBooks().isEmpty()) {
    throw new NotFoundException("No authors found");
}else {
    return authorRepository
            .findBooksByAuthorId(id)
            .stream()
            .map(bookMapper::bookToBookResponse)
            .collect(Collectors.toList());
}

    }
}
