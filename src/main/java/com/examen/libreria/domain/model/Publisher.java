package com.examen.libreria.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {
    private Long id;
    private String name;
    private String location;
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
