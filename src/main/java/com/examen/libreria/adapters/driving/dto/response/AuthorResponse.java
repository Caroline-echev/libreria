package com.examen.libreria.adapters.driving.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponse {

    private Long id;
    private String name;
    private String nationality;
    private Integer age;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}