package com.examen.libreria.adapters.driven.mapper;

import com.examen.libreria.adapters.driven.entity.BookGenreEntity;
import com.examen.libreria.domain.model.BookGenre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IBookGenreEntityMapper {

    BookGenreEntity toEntity(BookGenre bookGenre);

    @Mapping(source = "id", target = "id" )
    BookGenre toDomain(BookGenreEntity save);
}
