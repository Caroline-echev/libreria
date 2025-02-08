package com.examen.libreria.adapters.driving.dto.response;

import com.examen.libreria.domain.model.Author;
import com.examen.libreria.domain.model.Genre;
import com.examen.libreria.domain.model.Publisher;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class BookResponse {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Author author;
    private Publisher publisher;
    private Genre genre;

}
