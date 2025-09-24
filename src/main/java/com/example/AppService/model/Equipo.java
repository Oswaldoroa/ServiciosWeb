package com.example.AppService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Equipo {
    private UUID id;
    private  String nombreEquipo;
    private String paisOrigen;
    private  int anioFundacion;
    private String categoria;
    private String liga;
}
