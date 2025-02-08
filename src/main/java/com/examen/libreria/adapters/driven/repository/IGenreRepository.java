package com.examen.libreria.adapters.driven.repository;

import com.examen.libreria.adapters.driven.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenreRepository extends JpaRepository<GenreEntity, Long> {
    GenreEntity findByName(String name);
}
