package com.examen.libreria.adapters.driven.mapper;

import com.examen.libreria.adapters.driven.entity.PublisherEntity;
import com.examen.libreria.domain.model.Publisher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IPublisherEntityMapper {
    Publisher toPublisher(PublisherEntity publisherEntity);
    PublisherEntity toPublisherEntity(Publisher publisher);
}
