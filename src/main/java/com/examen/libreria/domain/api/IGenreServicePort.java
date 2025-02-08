package com.examen.libreria.domain.api;

import com.examen.libreria.domain.model.Genre;

public interface IGenreServicePort {
    Genre createGenre(Genre genre);
}
