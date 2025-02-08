package com.examen.libreria.adapters.driving.controller;

import com.examen.libreria.domain.api.IBookGenreServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookgenre")
public class BookGenreController {
    private final IBookGenreServicePort bookGenreServicePort;

    @PostMapping("/")
    public ResponseEntity<Void> createBookGenre(
            @RequestParam Long bookId,
            @RequestParam Long genreId) {

        bookGenreServicePort.createBookGenre(bookId, genreId);
        return ResponseEntity.ok().build();

    }
    @DeleteMapping("/")
    public ResponseEntity<Void> deleteBookGenre(@RequestParam Long bookId,
                                                @RequestParam Long genreId){

        bookGenreServicePort.deleteBookGenre(bookId, genreId);
        return ResponseEntity.ok().build();
    }

}
