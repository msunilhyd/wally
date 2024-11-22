package com.sunil.graphql;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record Book(Integer id, String name, Integer pageCount, Integer authorId) {
    public static List<Book> books = Arrays.asList(
            new Book(1, "Annihilation of Caste", 604, 3),
            new Book(2, "Harry Potter", 711, 2),
            new Book(3, "The Alchemist", 981, 1),
            new Book(4, "Why you act the way you do", 222, 3)
    );

    public static Optional<Book> getBookById(Integer id) {
        return books.stream()
                .filter(b -> b.id.equals(id))
                .findFirst();
    }
}
