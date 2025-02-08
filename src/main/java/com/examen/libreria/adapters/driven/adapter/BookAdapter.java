package com.examen.libreria.adapters.driven.adapter;

import com.examen.libreria.adapters.driven.mapper.IBookEntityMapper;
import com.examen.libreria.adapters.driven.repository.IBookRepository;
import com.examen.libreria.domain.model.Book;
import com.examen.libreria.domain.spi.IBookPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BookAdapter implements IBookPersistencePort {
    private final IBookRepository bookRepository;
    private final IBookEntityMapper bookEntityMapper;

    @Override
    public Book saveBook(Book book) {
        return bookEntityMapper.toBook(bookRepository.save(bookEntityMapper.toBookEntity(book)));
    }

    @Override
    public Book getBookById(Long id) {
        return bookEntityMapper.toBook(bookRepository.findById(id).orElse(null));
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll().stream().map(bookEntityMapper::toBook).toList();

    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getBooksByAuthor(Long id) {
        return bookRepository.findByAuthorId(id).stream().map(bookEntityMapper::toBook).toList();
    }

    @Override
    public List<Book> getBooksByPublisher(Long id) {
        return bookRepository.findByPublisherId(id).stream().map(bookEntityMapper::toBook).toList();
    }

    @Override
    public List<Book> searchBooksByTitle(String term) {
        return bookRepository.findByTitleContaining(term).stream().map(bookEntityMapper::toBook).toList();
    }

    @Override
    public List<Book> searchBooksByAuthor(String author) {
        return bookRepository.findByAuthorContaining(author).stream().map(bookEntityMapper::toBook).toList();
    }

}
