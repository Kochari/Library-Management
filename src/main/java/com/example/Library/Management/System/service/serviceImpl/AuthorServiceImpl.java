package com.example.Library.Management.System.service.serviceImpl;

import com.example.Library.Management.System.dto.AuthorResponse;
import com.example.Library.Management.System.entity.Author;
import com.example.Library.Management.System.entity.Book;
import com.example.Library.Management.System.mapper.AuthorMapper;
import com.example.Library.Management.System.repository.AuthorRepository;
import com.example.Library.Management.System.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public List<AuthorResponse> getAllAuthors() {
        return Optional.ofNullable(authorMapper.AllAuthorToResponse(authorRepository.findAll()))
                .orElseThrow(
                        () -> new NoSuchElementException("Author not found")
                );
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Author not found")
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
    public List<Book> getAllBooksByAuthorId(Long id) {

        return List.of();
    }
}
