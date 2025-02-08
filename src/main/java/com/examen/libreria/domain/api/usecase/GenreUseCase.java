package com.examen.libreria.domain.api.usecase;

import com.examen.libreria.domain.api.IGenreServicePort;
import com.examen.libreria.domain.model.Genre;
import com.examen.libreria.domain.spi.IGenrePersistencePort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class GenreUseCase implements IGenreServicePort {
    private  final IGenrePersistencePort genrePersistencePort;
    @Override
    public Genre createGenre(Genre genre) {
        genre.setCreatedAt(LocalDateTime.now());
        genre.setUpdatedAt(LocalDateTime.now());
        return genrePersistencePort.createGenre(genre);
    }
}
