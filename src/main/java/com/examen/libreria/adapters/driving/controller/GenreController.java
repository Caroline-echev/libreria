package com.examen.libreria.adapters.driving.controller;

import com.examen.libreria.adapters.driving.dto.request.GenreRequest;
import com.examen.libreria.adapters.driving.dto.response.GenreResponse;
import com.examen.libreria.adapters.driving.mapper.IGenreMapperDto;
import com.examen.libreria.domain.api.IGenreServicePort;
import com.examen.libreria.domain.model.Genre;
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
@RequestMapping("/genre")
public class GenreController {

    private final IGenreServicePort genreServicePort;
    private final IGenreMapperDto genreMapperDto;

    @PostMapping("/")
    public ResponseEntity<GenreResponse> createGenre(@Valid @RequestBody GenreRequest genreRequest) {
        Genre genre = genreServicePort.createGenre(genreMapperDto.toGenre(genreRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(genreMapperDto.toGenreResponse(genre));
    }

}
