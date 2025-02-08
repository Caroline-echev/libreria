package com.examen.libreria.adapters.driven.mapper;

import com.examen.libreria.adapters.driven.entity.AuthorEntity;
import com.examen.libreria.domain.model.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IAuthorEntityMapper {
    Author toAuthor(AuthorEntity authorEntity);
    AuthorEntity toAuthorEntity(Author author);
}
