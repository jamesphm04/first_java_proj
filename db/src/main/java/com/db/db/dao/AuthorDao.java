package com.db.db.dao;

import com.db.db.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {
    void create(Author author);
    Optional<Author> findOne(long authorId);
    List<Author> find();
    void update(long id, Author author);
    void delete(long id);
}
