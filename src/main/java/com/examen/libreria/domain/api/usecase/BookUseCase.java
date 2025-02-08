package com.examen.libreria.domain.api.usecase;

import com.examen.libreria.domain.api.IBookServicePort;
import com.examen.libreria.domain.model.Book;
import com.examen.libreria.domain.model.BookGenre;
import com.examen.libreria.domain.model.Genre;
import com.examen.libreria.domain.spi.*;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.*;

@RequiredArgsConstructor
public class BookUseCase implements IBookServicePort {
    private final IAuthorPersistencePort authorPersistencePort;
    private final IPublisherPersistencePort publisherPersistencePort;
    private final IBookPersistencePort bookPersistencePort;
    private final IGenrePersistencePort genrePersistencePort;
    private final IBookGenrePersistencePort bookGenrePersistencePort;
    @Override
    public Book saveBook(Long genreId, Long authorId, Long publisherId, Book book) {
        book.setCreatedAt(LocalDateTime.now());
        book.setUpdatedAt(LocalDateTime.now());
        book.setAuthor(authorPersistencePort.getAuthorById(authorId));
        book.setPublisher(publisherPersistencePort.getPublisherById(publisherId));
        Book savedBook = bookPersistencePort.saveBook(book);
        BookGenre bookGenre = new BookGenre();
        bookGenre.setBook(savedBook);
        Genre genre = genrePersistencePort.getGenreById(genreId);
        bookGenre.setGenre(genre);
        bookGenrePersistencePort.createBookGenre(bookGenre);
        savedBook.setGenre(genre);
         return savedBook;
    }

    @Override
    public Book getBookById(Long id) {
        Book book = bookPersistencePort.getBookById(id);
        BookGenre bookGenre = bookGenrePersistencePort.getBookGenreByBookId(book.getId());
        book.setGenre(genrePersistencePort.getGenreById(bookGenre.getGenre().getId()));
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = bookPersistencePort.getAllBooks();
        for (Book book : books) {
            BookGenre bookGenre = bookGenrePersistencePort.getBookGenreByBookId(book.getId());
            book.setGenre(genrePersistencePort.getGenreById(bookGenre.getGenre().getId()));
        }
        return books;
    }

    @Override
    public Book updateBook( Long id,Book book) {
        Book bookToUpdate = bookPersistencePort.getBookById(id);
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setDescription(book.getDescription());
        bookToUpdate.setUpdatedAt(LocalDateTime.now());
        Book updatedBook = bookPersistencePort.saveBook(bookToUpdate);
        BookGenre bookGenre = bookGenrePersistencePort.getBookGenreByBookId(updatedBook.getId());
        updatedBook.setGenre(genrePersistencePort.getGenreById(bookGenre.getGenre().getId()));
        return updatedBook;

    }
    @Override
    public void deleteBook(Long id) {
        Book book = bookPersistencePort.getBookById(id);
        if (book == null) {
            throw new RuntimeException("El libro con ID " + id + " no existe.");
        }

        List<BookGenre> bookGenres = bookGenrePersistencePort.getBookGenreByBookIdList(id);
        for (BookGenre bookGenre : bookGenres) {
            bookGenrePersistencePort.deleteBookGenre(bookGenre.getId());
        }
        bookPersistencePort.deleteBook(id);
    }

    @Override
    public List<Book> getBooksByAuthor(Long id) {
        List<Book> books = bookPersistencePort.getBooksByAuthor(id);
        for (Book book : books) {
            BookGenre bookGenre = bookGenrePersistencePort.getBookGenreByBookId(book.getId());
            book.setGenre(genrePersistencePort.getGenreById(bookGenre.getGenre().getId()));
        }
        return books;
    }

    @Override
    public List<Book> getBooksByPublisher(Long id) {
        List<Book> books = bookPersistencePort.getBooksByPublisher(id);
        for (Book book : books) {
            BookGenre bookGenre = bookGenrePersistencePort.getBookGenreByBookId(book.getId());
            book.setGenre(genrePersistencePort.getGenreById(bookGenre.getGenre().getId()));
        }
        return books;
    }

    @Override
    public List<Book> searchBooks(String term, String opc ) {
        List<Book> books = new ArrayList<>();
        switch (opc) {
            case "title":
                books = bookPersistencePort.searchBooksByTitle(term);
                setGenres(books);
                return books;
            case "author":
                books = bookPersistencePort.searchBooksByAuthor(term);
                setGenres(books);
                return books;
            case "genre":
                Genre genre = genrePersistencePort.getGenreByName(term);
                List<BookGenre> bookGenres = bookGenrePersistencePort.getBookGenreByGenreId(genre.getId());

                Set<Book> uniqueBooks = new HashSet<>();

                for (BookGenre bookGenre : bookGenres) {
                    uniqueBooks.add(bookPersistencePort.getBookById(bookGenre.getBook().getId()));
                }

                books = new ArrayList<>(uniqueBooks);
                setGenres(books);

                books.sort(Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));

                return books;
            default:
                throw new RuntimeException("Opción no válida");
        }


    }

    private void setGenres(List<Book> books) {
        for (Book book : books) {
            BookGenre bookGenre = bookGenrePersistencePort.getBookGenreByBookId(book.getId());
            book.setGenre(genrePersistencePort.getGenreById(bookGenre.getGenre().getId()));
        }
    }
}
