package com.examen.libreria.domain.spi;

import com.examen.libreria.domain.model.Author;

public interface IAuthorPersistencePort {
    Author createAuthor(Author author);
    Author getAuthorById(Long id);
}
