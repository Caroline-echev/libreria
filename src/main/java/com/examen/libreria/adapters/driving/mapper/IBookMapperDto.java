package com.examen.libreria.adapters.driving.mapper;

import com.examen.libreria.adapters.driving.dto.request.BookRequest;
import com.examen.libreria.adapters.driving.dto.request.BookUpdateRequest;
import com.examen.libreria.adapters.driving.dto.response.BookResponse;
import com.examen.libreria.domain.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IBookMapperDto {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "author", ignore = true),
            @Mapping(target = "publisher", ignore = true),
            @Mapping(target = "genre", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true)
    })
    Book toBook(BookRequest bookRequest);


    BookResponse toBookResponse(Book book);
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "author", ignore = true),
            @Mapping(target = "publisher", ignore = true),
            @Mapping(target = "genre", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true)
    })
    Book updateToBook(BookUpdateRequest bookUpdateRequest);
}
