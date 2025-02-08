package com.examen.libreria.adapters.driven.repository;

import com.examen.libreria.adapters.driven.entity.BookGenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBookGenreRepository extends JpaRepository<BookGenreEntity, Long> {
    @Query("SELECT bg FROM BookGenreEntity bg WHERE bg.book.id = :bookId")
    BookGenreEntity findByBookId(Long bookId);
    @Query("SELECT bg FROM BookGenreEntity bg WHERE bg.book.id IN :bookIdList")
    List<BookGenreEntity> findByBookIdList(Long bookIdList);

    @Query("SELECT bg FROM BookGenreEntity bg WHERE bg.book.id = :bookId AND bg.genre.id = :genreId")
    BookGenreEntity findByBookIdAndGenreId(Long bookId, Long genreId);

    @Query("SELECT bg FROM BookGenreEntity bg WHERE bg.genre.id = :genreId")
    List<BookGenreEntity> findByGenreId(Long genreId);
}
