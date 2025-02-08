package com.examen.libreria.adapters.driven.repository;

import com.examen.libreria.adapters.driven.entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPublisherRepository extends JpaRepository<PublisherEntity, Long> {

}
