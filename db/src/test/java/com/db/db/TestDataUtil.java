package com.db.db;

import com.db.db.domain.Author;
import com.db.db.domain.Book;

public class TestDataUtil {
    private TestDataUtil() {

    }

    public static Author createTestAuthorA() {
        return Author.builder()
                .id(1L)
                .name("James")
                .age(25)
                .build();
    }

    public static Author createTestAuthorB() {
        return Author.builder()
                .id(2L)
                .name("Robin")
                .age(60)
                .build();
    }

    public static Author createTestAuthorC() {
        return Author.builder()
                .id(3L)
                .name("Axell")
                .age(60)
                .build();
    }

    public static Book createTestBookA(final Author author) {
        return Book.builder()
                .isbn("904-1-4355-1665-1")
                .title("Computer vision1")
                .author(author)
                .build();
    }

    public static Book createTestBookB(Author author) {
        return Book.builder()
                .isbn("904-1-4355-1665-2")
                .title("Computer vision2")
                .author(author)
                .build();
    }

    public static Book createTestBookC(Author author) {
        return Book.builder()
                .isbn("904-1-4355-1665-3")
                .title("Computer vision3")
                .author(author)
                .build();
    }
}
