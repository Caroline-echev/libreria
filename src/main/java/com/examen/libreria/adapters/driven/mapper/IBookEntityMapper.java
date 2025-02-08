package com.examen.libreria.adapters.driven.mapper;

import com.examen.libreria.adapters.driven.entity.BookEntity;
import com.examen.libreria.domain.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {IAuthorEntityMapper.class, IPublisherEntityMapper.class})
public interface IBookEntityMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "title", target = "title"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "createdAt", target = "createdAt"),
            @Mapping(source = "updatedAt", target = "updatedAt"),
            @Mapping(source = "author", target = "author"),
            @Mapping(source = "publisher", target = "publisher"),
            @Mapping(target = "genre", ignore = true)
    })
    Book toBook(BookEntity bookEntity);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "title", target = "title"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "createdAt", target = "createdAt"),
            @Mapping(source = "updatedAt", target = "updatedAt"),
            @Mapping(source = "author", target = "author"),
            @Mapping(source = "publisher", target = "publisher")
    })
    BookEntity toBookEntity(Book book);
}
