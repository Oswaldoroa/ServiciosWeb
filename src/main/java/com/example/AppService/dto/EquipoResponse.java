package com.example.AppService.dto;

public record EquipoResponse (
    String nombreEquipo,
    String paisOrigen,
    int anioFundacion,
    String categoria,
    String liga
) {}
