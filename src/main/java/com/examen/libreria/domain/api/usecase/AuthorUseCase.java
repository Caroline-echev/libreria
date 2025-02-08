package com.examen.libreria.domain.api.usecase;

import com.examen.libreria.domain.api.IAuthorServicePort;
import com.examen.libreria.domain.model.Author;
import com.examen.libreria.domain.spi.IAuthorPersistencePort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class AuthorUseCase implements IAuthorServicePort {
    private final IAuthorPersistencePort authorPersistencePort;

    @Override
    public Author createAuthor(Author author) {
        author.setCreatedAt(LocalDateTime.now());
        author.setUpdatedAt(LocalDateTime.now());
        return authorPersistencePort.createAuthor(author);
    }
}
