package com.examen.libreria.configuration.bean;

import com.examen.libreria.adapters.driven.adapter.*;
import com.examen.libreria.adapters.driven.mapper.*;
import com.examen.libreria.adapters.driven.repository.*;
import com.examen.libreria.domain.api.*;
import com.examen.libreria.domain.api.usecase.*;
import com.examen.libreria.domain.spi.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class BeanConfiguration {
    private final IAuthorEntityMapper authorEntityMapper;
    private final IAuthorRepository authorRepository;
    private final IPublisherEntityMapper publisherEntityMapper;
    private final IPublisherRepository publisherRepository;
    private final IGenreRepository genreRepository;
    private final IGenreEntityMapper genreEntityMapper;
    private final IBookEntityMapper bookEntityMapper;
    private final IBookRepository bookRepository;
    private final IBookGenreRepository bookGenreRepository;
    private final IBookGenreEntityMapper bookGenreEntityMapper;
    @Bean
    public IAuthorPersistencePort authorPersistencePort() {
        return new AuthorAdapter(authorRepository, authorEntityMapper);
    }
    @Bean
    public IAuthorServicePort authorServicePort() {
        return new AuthorUseCase(authorPersistencePort());
    }

    @Bean
    public IPublisherPersistencePort publisherPersistencePort() {
        return new PublisherAdapter(publisherRepository, publisherEntityMapper);
    }
    @Bean
    public IPublisherServicePort publisherServicePort() {
        return new PublisherUseCase(publisherPersistencePort());
    }

    @Bean
    public IGenrePersistencePort genrePersistencePort() {
        return new GenreAdapter(genreRepository, genreEntityMapper);
    }
    @Bean
    public IGenreServicePort genreServicePort() {
        return new GenreUseCase(genrePersistencePort());
    }
    @Bean
    public IBookPersistencePort bookPersistencePort() {
        return new BookAdapter(bookRepository, bookEntityMapper);
    }
    @Bean
    public IBookServicePort bookServicePort() {
        return new BookUseCase(authorPersistencePort(),publisherPersistencePort(), bookPersistencePort(),
                genrePersistencePort(), bookGenrePersistencePort());
    }
    @Bean
    public IBookGenrePersistencePort bookGenrePersistencePort() {
        return new BookGenreAdapter(bookGenreRepository, bookGenreEntityMapper);
    }
    @Bean
    public IBookGenreServicePort bookGenreServicePort() {
        return new BookGenreUseCase(bookPersistencePort(), genrePersistencePort(), bookGenrePersistencePort());
    }
}