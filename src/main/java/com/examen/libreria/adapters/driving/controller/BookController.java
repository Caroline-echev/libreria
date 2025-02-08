package com.examen.libreria.adapters.driving.controller;

import com.examen.libreria.adapters.driving.dto.request.BookRequest;
import com.examen.libreria.adapters.driving.dto.request.BookUpdateRequest;
import com.examen.libreria.adapters.driving.dto.response.BookResponse;
import com.examen.libreria.adapters.driving.mapper.IBookMapperDto;
import com.examen.libreria.domain.api.IBookServicePort;
import com.examen.libreria.domain.model.Book;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final IBookServicePort bookServicePort;
    private final IBookMapperDto bookMapperDto;

    @PostMapping("/")
    public ResponseEntity<BookResponse> saveBook(@Valid @RequestBody BookRequest bookRequest) {
        Book book = bookServicePort.saveBook(bookRequest.getGenreId(), bookRequest.getAuthorId(), bookRequest.getPublisherId(), bookMapperDto.toBook(bookRequest));
        BookResponse bookResponse = bookMapperDto.toBookResponse(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookResponse);
      }

      @GetMapping("/{id}")
      public ResponseEntity<BookResponse> getBookById(@PathVariable Long id) {
          Book book = bookServicePort.getBookById(id);
          BookResponse bookResponse = bookMapperDto.toBookResponse(book);
          return ResponseEntity.ok(bookResponse);
      }

      @GetMapping("/all")
      public ResponseEntity<Iterable<BookResponse>> getAllBooks() {
          List<Book> books = bookServicePort.getAllBooks();
          List<BookResponse> bookResponses = books.stream()
                  .map(bookMapperDto::toBookResponse)
                  .collect(Collectors.toList());

          return ResponseEntity.ok(bookResponses);
      }

      @PutMapping("/{id}")
      public ResponseEntity<BookResponse> updateBook(@PathVariable Long id, @Valid @RequestBody BookUpdateRequest bookRequest) {
          Book book = bookServicePort.updateBook( id,  bookMapperDto.updateToBook( bookRequest));
          BookResponse bookResponse = bookMapperDto.toBookResponse(book);
          return ResponseEntity.ok(bookResponse);
      }
      @DeleteMapping("/{id}")
      public ResponseEntity<String> deleteBook(@PathVariable Long id) {
          bookServicePort.deleteBook(id);
          return ResponseEntity.ok("Book deleted successfully");
      }

      @GetMapping("/author/{id}")
      public ResponseEntity<List<BookResponse>> getBooksByAuthor(@PathVariable Long id) {
          List<Book> books = bookServicePort.getBooksByAuthor(id);
          List<BookResponse> bookResponses = books.stream()
                  .map(bookMapperDto::toBookResponse)
                  .collect(Collectors.toList());
          return ResponseEntity.ok(bookResponses);
      }
      @GetMapping("/publisher/{id}")
      public ResponseEntity<List<BookResponse>> getBooksByPublisher(@PathVariable Long id) {
          List<Book> books = bookServicePort.getBooksByPublisher(id);
          List<BookResponse> bookResponses = books.stream()
                  .map(bookMapperDto::toBookResponse)
                  .collect(Collectors.toList());
          return ResponseEntity.ok(bookResponses);
      }

      //opc puede ser title, author o genre
    @GetMapping("/search/")
    public ResponseEntity<List<BookResponse>> searchBooks(@RequestParam String term, @RequestParam String opc) {
        List<Book> books = bookServicePort.searchBooks(term, opc);
        List<BookResponse> bookResponses = books.stream()
                .map(bookMapperDto::toBookResponse)
                .toList();
        return ResponseEntity.ok(bookResponses);
    }

}

