package com.example.AppService.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record EquipoRequest (

    @NotBlank(message = "El nombre del equipo es obligatorio")
    String nombreEquipo,

    @NotBlank(message = "El pais de origen es obligatorio")
    String paisOrigen,

    @Min(value = 1800,message = "El año tiene que ser valido")
    int anioFundacion,

    @NotBlank(message = "La categoria es obligatoria")
    String categoria,

    @NotBlank(message = "La liga es obligatoria")
    String liga
) {}
