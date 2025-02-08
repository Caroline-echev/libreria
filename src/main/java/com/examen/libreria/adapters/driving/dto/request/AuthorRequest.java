package com.examen.libreria.adapters.driving.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String name;
    @NotBlank(message = "La nacionalidad es obligatoria")
    private String nationality;
    @NotNull(message = "La edad es obligatoria")
    @Size(min = 18, message = "La edad debe ser mayor a 18 años")
    private Integer age;
}