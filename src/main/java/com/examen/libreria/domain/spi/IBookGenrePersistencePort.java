package com.examen.libreria.domain.spi;

import com.examen.libreria.domain.model.BookGenre;

import java.util.List;

public interface IBookGenrePersistencePort {
    BookGenre createBookGenre(BookGenre bookGenre);
    BookGenre getBookGenreByBookId(Long bookId);
    List<BookGenre> getBookGenreByBookIdList(Long bookId);
    void deleteBookGenre(Long id);
    BookGenre getBookGenreByBookIdAndGenreId(Long bookId, Long genreId);
    List<BookGenre> getBookGenreByGenreId(Long genreId);
}
