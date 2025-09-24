package com.example.AppService.dto;

import java.util.UUID;

public record EquipoResponse (
        UUID id,
    String nombreEquipo,
    String paisOrigen,
    int anioFundacion,
    String categoria,
    String liga
) {}
