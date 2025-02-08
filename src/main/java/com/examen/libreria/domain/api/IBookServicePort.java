package com.examen.libreria.domain.api;

import com.examen.libreria.domain.model.Book;

import java.util.List;

public interface IBookServicePort {
    Book saveBook(Long genreId, Long authorId, Long publisherId, Book book);
    Book getBookById(Long id);
    List<Book> getAllBooks();
    Book updateBook(Long id, Book book);
    void  deleteBook(Long id);
    List<Book> getBooksByAuthor(Long id);
    List<Book> getBooksByPublisher(Long id);
    List<Book> searchBooks(String term, String opc );
}
