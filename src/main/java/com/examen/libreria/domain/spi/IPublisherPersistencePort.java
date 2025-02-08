package com.examen.libreria.domain.spi;

import com.examen.libreria.domain.model.Publisher;

public interface IPublisherPersistencePort {
    Publisher createPublisher(Publisher publisher);
    Publisher getPublisherById(Long id);
}
