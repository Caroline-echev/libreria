package com.examen.libreria.adapters.driven.repository;

import com.examen.libreria.adapters.driven.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorRepository extends JpaRepository<AuthorEntity, Long> {
}
