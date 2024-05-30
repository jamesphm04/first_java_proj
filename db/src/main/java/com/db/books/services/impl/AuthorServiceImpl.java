package com.db.books.services.impl;

import com.db.books.domain.entities.AuthorEntity;
import com.db.books.repositories.AuthorRepository;
import com.db.books.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorEntity createUpdate(AuthorEntity authorEntity) {
        return authorRepository.save(authorEntity);
    }

    @Override
    public List<AuthorEntity> findAll() {
        return StreamSupport.stream(authorRepository
                        .findAll()
                        .spliterator(),
                        false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AuthorEntity> findOne(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public boolean isExist(Long id) {
        return authorRepository.existsById(id);
    }

    @Override
    public AuthorEntity partialUpdate(Long id, AuthorEntity authorEntity) {
        authorEntity.setId(id);

        Optional<AuthorEntity> optionalExistingAuthorEntity = authorRepository.findById(id);
        if (optionalExistingAuthorEntity.isPresent()) {
            AuthorEntity existingAuthorEntity = optionalExistingAuthorEntity.get();

            if (authorEntity.getName() != null) {
                existingAuthorEntity.setName(authorEntity.getName());
            }

            if (authorEntity.getAge() != null) {
                existingAuthorEntity.setAge(authorEntity.getAge());
            }

            return authorRepository.save(existingAuthorEntity);
        } else {
            throw new RuntimeException("Something went wrong with partial-updating author");
        }
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
}
