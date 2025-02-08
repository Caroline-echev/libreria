package com.examen.libreria.adapters.driving.controller;

import com.examen.libreria.adapters.driving.dto.request.PublisherRequest;
import com.examen.libreria.adapters.driving.dto.response.PublisherResponse;
import com.examen.libreria.adapters.driving.mapper.IPublisherMapperDto;
import com.examen.libreria.domain.api.IPublisherServicePort;
import com.examen.libreria.domain.model.Publisher;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/publisher")
public class PublisherController {
    private final IPublisherServicePort publisherServicePort;
    private final IPublisherMapperDto publisherMapperDto;

    @PostMapping("/")
    public ResponseEntity<PublisherResponse> createPublisher(@Valid @RequestBody PublisherRequest publisherRequest) {
        Publisher publisher = publisherServicePort.createPublisher(publisherMapperDto.toPublisher(publisherRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(publisherMapperDto.toPublisherResponse(publisher));
    }

}
