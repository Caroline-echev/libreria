package com.examen.libreria.adapters.driving.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    @NotBlank(message = "El título es obligatorio")
    private String title;
    @NotBlank(message = "La descripción es obligatoria")
    private String description;
    @NotNull(message = "El autor es obligatorio")
    private Long authorId;
    @NotNull(message = "El editor es obligatorio")
    private Long publisherId;
    @NotNull(message = "El género es obligatorio")
    private Long genreId;


}

