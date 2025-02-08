package com.examen.libreria.adapters.driven.adapter;

import com.examen.libreria.adapters.driven.mapper.IGenreEntityMapper;
import com.examen.libreria.adapters.driven.repository.IGenreRepository;
import com.examen.libreria.domain.model.Genre;
import com.examen.libreria.domain.spi.IGenrePersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GenreAdapter implements IGenrePersistencePort {
    private final IGenreRepository genreRepository;
    private final IGenreEntityMapper genreEntityMapper;

    @Override
    public Genre createGenre(Genre genre) {
        return genreEntityMapper.toGenre(genreRepository.save(genreEntityMapper.toGenreEntity(genre)));
    }

    @Override
    public Genre getGenreById(Long id) {
        return genreEntityMapper.toGenre(genreRepository.findById(id).orElse(null));
    }

    @Override
    public Genre getGenreByName(String name) {
        return genreEntityMapper.toGenre(genreRepository.findByName(name));
    }
}
