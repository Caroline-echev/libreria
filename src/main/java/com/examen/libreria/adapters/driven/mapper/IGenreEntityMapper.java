package com.examen.libreria.adapters.driven.mapper;

import com.examen.libreria.adapters.driven.entity.GenreEntity;
import com.examen.libreria.domain.model.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IGenreEntityMapper {

    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "updatedAt", target = "updatedAt")
    Genre toGenre(GenreEntity genreEntity);

    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "updatedAt", target = "updatedAt")
    GenreEntity toGenreEntity(Genre genre);
}
