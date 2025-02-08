package com.examen.libreria.adapters.driven.adapter;

import com.examen.libreria.adapters.driven.mapper.IBookGenreEntityMapper;
import com.examen.libreria.adapters.driven.repository.IBookGenreRepository;
import com.examen.libreria.domain.model.BookGenre;
import com.examen.libreria.domain.spi.IBookGenrePersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BookGenreAdapter implements IBookGenrePersistencePort {
    private final IBookGenreRepository bookGenreRepository;
    private final IBookGenreEntityMapper bookGenreEntityMapper;
    @Override
    public BookGenre createBookGenre(BookGenre bookGenre) {
        return bookGenreEntityMapper.toDomain(bookGenreRepository.save(bookGenreEntityMapper.toEntity(bookGenre)));
    }

    @Override
    public BookGenre getBookGenreByBookId(Long bookId) {
        return bookGenreEntityMapper.toDomain(bookGenreRepository.findByBookId(bookId));
    }

    @Override
    public List<BookGenre> getBookGenreByBookIdList(Long bookId) {
        return bookGenreRepository.findByBookIdList(bookId).stream().map(bookGenreEntityMapper::toDomain).toList();
    }

    @Override
    public void deleteBookGenre(Long id) {
        bookGenreRepository.deleteById(id);
    }

    @Override
    public BookGenre getBookGenreByBookIdAndGenreId(Long bookId, Long genreId) {
        return bookGenreEntityMapper.toDomain(bookGenreRepository.findByBookIdAndGenreId(bookId, genreId));
    }

    @Override
    public List<BookGenre> getBookGenreByGenreId(Long genreId) {
        return bookGenreRepository.findByGenreId(genreId).stream().map(bookGenreEntityMapper::toDomain).toList();
    }

}
