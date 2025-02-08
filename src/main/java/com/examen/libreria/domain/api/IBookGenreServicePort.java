package com.examen.libreria.domain.api;

public interface IBookGenreServicePort {
    void createBookGenre(Long bookId, Long genreId);
    void deleteBookGenre(Long bookId, Long genreId);
}
