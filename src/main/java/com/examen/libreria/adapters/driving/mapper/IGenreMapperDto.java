package com.examen.libreria.adapters.driving.mapper;

import com.examen.libreria.adapters.driving.dto.request.GenreRequest;
import com.examen.libreria.adapters.driving.dto.response.GenreResponse;
import com.examen.libreria.domain.model.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IGenreMapperDto {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true)
    })
    Genre toGenre(GenreRequest genreRequest);
    GenreResponse toGenreResponse(Genre genre);
}