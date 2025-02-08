package com.examen.libreria.domain.api.usecase;

import com.examen.libreria.domain.api.IPublisherServicePort;
import com.examen.libreria.domain.model.Publisher;
import com.examen.libreria.domain.spi.IPublisherPersistencePort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class PublisherUseCase implements IPublisherServicePort {
    private final IPublisherPersistencePort publisherPersistencePort;

    @Override
    public Publisher createPublisher(Publisher publisher) {
        publisher.setCreatedAt(LocalDateTime.now());
        publisher.setUpdatedAt(LocalDateTime.now());
        return publisherPersistencePort.createPublisher(publisher);
    }
}
