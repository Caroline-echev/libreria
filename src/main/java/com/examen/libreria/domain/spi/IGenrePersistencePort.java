package com.examen.libreria.domain.spi;

import com.examen.libreria.domain.model.Genre;

public interface IGenrePersistencePort {
    Genre createGenre(Genre genre);
    Genre getGenreById(Long id);
    Genre getGenreByName(String name);

}
