package com.examen.libreria.adapters.driven.repository;

import com.examen.libreria.adapters.driven.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBookRepository extends JpaRepository<BookEntity, Long> {
    @Query("SELECT b FROM BookEntity b WHERE b.author.id = :authorId")
    List<BookEntity> findByAuthorId(Long authorId);

    @Query("SELECT b FROM BookEntity b WHERE b.publisher.id = :publisherId")
    List<BookEntity> findByPublisherId (Long publisherId);

    @Query("SELECT b FROM BookEntity b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%')) ORDER BY b.title ASC")
    List<BookEntity> findByTitleContaining(@Param("title") String title);

    @Query("SELECT b FROM BookEntity b WHERE LOWER(b.author.name) LIKE LOWER(CONCAT('%', :author, '%')) ORDER BY b.title ASC")
    List<BookEntity> findByAuthorContaining(String author);
}
