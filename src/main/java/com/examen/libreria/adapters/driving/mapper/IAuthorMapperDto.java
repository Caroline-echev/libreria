package com.examen.libreria.adapters.driving.mapper;

import com.examen.libreria.adapters.driving.dto.request.AuthorRequest;
import com.examen.libreria.adapters.driving.dto.response.AuthorResponse;
import com.examen.libreria.domain.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IAuthorMapperDto {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true)
    })
    Author toAuthor(AuthorRequest authorRequest);

    AuthorResponse toAuthorResponse(Author author);
}
