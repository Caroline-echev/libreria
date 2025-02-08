package com.examen.libreria.adapters.driving.mapper;

import com.examen.libreria.adapters.driving.dto.request.PublisherRequest;
import com.examen.libreria.adapters.driving.dto.response.PublisherResponse;
import com.examen.libreria.domain.model.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IPublisherMapperDto {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true)
    })
    Publisher toPublisher(PublisherRequest publisherRequest);

    PublisherResponse toPublisherResponse(Publisher publisher);
}