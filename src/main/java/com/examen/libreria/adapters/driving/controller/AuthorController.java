package com.examen.libreria.adapters.driving.controller;

import com.examen.libreria.adapters.driving.dto.request.AuthorRequest;
import com.examen.libreria.adapters.driving.mapper.IAuthorMapperDto;
import com.examen.libreria.domain.api.IAuthorServicePort;
import com.examen.libreria.domain.model.Author;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorController {
    private final IAuthorServicePort authorServicePort;
    private final IAuthorMapperDto authorMapperDto;

    @PostMapping("/")
    public ResponseEntity<Author> createAuthor(@Valid @RequestBody AuthorRequest authorRequest) {
        Author author = authorServicePort.createAuthor(authorMapperDto.toAuthor(authorRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(author);
    }

}
