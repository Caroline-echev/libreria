package com.examen.libreria.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookGenre {
    private Long id;
    private Book book;

    private Genre genre;

}