package com.examen.libreria.domain.api.usecase;

import com.examen.libreria.domain.api.IBookGenreServicePort;
import com.examen.libreria.domain.model.BookGenre;
import com.examen.libreria.domain.spi.IBookGenrePersistencePort;
import com.examen.libreria.domain.spi.IBookPersistencePort;
import com.examen.libreria.domain.spi.IGenrePersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BookGenreUseCase implements IBookGenreServicePort {
    private final IBookPersistencePort bookPersistencePort;
    private final IGenrePersistencePort genrePersistencePort;
    private final IBookGenrePersistencePort bookGenrePersistencePort;

    @Override
    public void createBookGenre(Long bookId, Long genreId) {
        BookGenre bookGenre = new BookGenre();
        bookGenre.setBook(bookPersistencePort.getBookById(bookId));
        bookGenre.setGenre(genrePersistencePort.getGenreById(genreId));
        bookGenrePersistencePort.createBookGenre(bookGenre);

    }

    @Override
    public void deleteBookGenre(Long bookId, Long genreId) {
        BookGenre bookGenre = bookGenrePersistencePort.getBookGenreByBookIdAndGenreId(bookId, genreId);
        if(bookGenre == null) return;
        bookGenrePersistencePort.deleteBookGenre(bookGenre.getId());
    }
}
