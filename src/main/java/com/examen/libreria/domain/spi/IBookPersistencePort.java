package com.examen.libreria.domain.spi;

import com.examen.libreria.domain.model.Book;

import java.util.List;

public interface IBookPersistencePort {
    Book saveBook(Book book);
    Book getBookById(Long id);
    List<Book> getAllBooks();
    void deleteBook(Long id);
    List<Book> getBooksByAuthor(Long id);
    List<Book> getBooksByPublisher(Long id);
    List<Book> searchBooksByTitle(String title);
    List<Book> searchBooksByAuthor(String author);


}
