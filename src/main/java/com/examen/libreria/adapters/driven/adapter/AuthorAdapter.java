package com.examen.libreria.adapters.driven.adapter;

import com.examen.libreria.adapters.driven.mapper.IAuthorEntityMapper;
import com.examen.libreria.adapters.driven.repository.IAuthorRepository;
import com.examen.libreria.domain.model.Author;
import com.examen.libreria.domain.spi.IAuthorPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthorAdapter implements IAuthorPersistencePort {
    private final IAuthorRepository authorRepository;
    private final IAuthorEntityMapper authorEntityMapper;
    @Override
    public Author createAuthor(Author author) {
        return authorEntityMapper.toAuthor(authorRepository.save(authorEntityMapper.toAuthorEntity(author)));
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorEntityMapper.toAuthor(authorRepository.findById(id).orElse(null));
    }


}
