package com.examen.libreria.adapters.driven.adapter;

import com.examen.libreria.adapters.driven.mapper.IPublisherEntityMapper;
import com.examen.libreria.adapters.driven.repository.IPublisherRepository;
import com.examen.libreria.domain.model.Publisher;
import com.examen.libreria.domain.spi.IPublisherPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PublisherAdapter implements IPublisherPersistencePort {
    private final IPublisherRepository publisherRepository;
    private final IPublisherEntityMapper  publisherEntityMapper;
    @Override
    public Publisher createPublisher(Publisher publisher) {
        return publisherEntityMapper.toPublisher(publisherRepository.save(publisherEntityMapper.toPublisherEntity(publisher)));
    }

    @Override
    public Publisher getPublisherById(Long id) {
        return publisherEntityMapper.toPublisher(publisherRepository.findById(id).orElse(null));
    }
}
