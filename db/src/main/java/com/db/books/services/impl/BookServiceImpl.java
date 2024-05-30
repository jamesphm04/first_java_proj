package com.db.books.services.impl;

import com.db.books.domain.entities.AuthorEntity;
import com.db.books.domain.entities.BookEntity;
import com.db.books.repositories.BookRepository;
import com.db.books.services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookEntity createUpdate(String isbn, BookEntity bookEntity) {
        bookEntity.setIsbn(isbn);
        return bookRepository.save(bookEntity);
    }

    @Override
    public List<BookEntity> findAll() {
        return StreamSupport.stream(bookRepository
                                .findAll()
                                .spliterator(),
                        false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BookEntity> findOne(String isbn) {
        return bookRepository.findById(isbn);
    }

    @Override
    public boolean isExist(String isbn) {
        return bookRepository.existsById(isbn);
    }

    @Override
    public BookEntity partialUpdate(String isbn, BookEntity bookEntity) {
        bookEntity.setIsbn(isbn);

        Optional<BookEntity> optionalBookEntity = bookRepository.findById(isbn);

        if (optionalBookEntity.isPresent()) {
            BookEntity existingBookEntity = optionalBookEntity.get();

            if (bookEntity.getTitle() != null) {
                existingBookEntity.setTitle(bookEntity.getTitle());
            }

            if (bookEntity.getAuthorEntity() != null) {
                existingBookEntity.setAuthorEntity(bookEntity.getAuthorEntity());
            }

            return bookRepository.save(existingBookEntity);
        } else {
            throw new RuntimeException("Something went wrong with partial-updating book");
        }
    }

    @Override
    public void delete(String isbn) {
        bookRepository.deleteById(isbn);
    }
}
