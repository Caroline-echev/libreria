package com.examen.libreria.adapters.driving.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherRequest {
    @NotBlank(message = "El nombre es obligatorio")
    private String name;
    @NotBlank(message = "La ubicación es obligatoria")
    private String location;
}
