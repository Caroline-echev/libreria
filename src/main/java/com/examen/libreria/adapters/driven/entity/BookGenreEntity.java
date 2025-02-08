package com.examen.libreria.adapters.driven.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "books_has_genres")
@AllArgsConstructor
@NoArgsConstructor
public class BookGenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "books_id")
    private BookEntity book;


    @ManyToOne
    @JoinColumn(name = "genres_id")
    private GenreEntity genre;

}