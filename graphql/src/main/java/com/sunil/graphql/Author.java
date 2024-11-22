package com.sunil.graphql;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record Author(
        Integer id,
        String name
) {
    public static List<Author> authors = Arrays.asList(
            new Author(1, "Ernest Hemmingway"),
            new Author(2, "Dr. B. R. Ambedkar"),
            new Author(3, "Arundati Roy")
    );

    public static Optional<Author> getAuthorById(Integer id) {
        return authors.stream()
                .filter(b -> b.id.equals(id))
                .findFirst();
    }
}
