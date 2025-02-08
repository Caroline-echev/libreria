package com.examen.libreria.adapters.driving.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdateRequest {

    @NotBlank(message = "El título es obligatorio")
    private String title;
    @NotBlank(message = "La descripción es obligatoria")
    private String description;

}

