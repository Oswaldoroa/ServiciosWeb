package com.example.AppService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Equipo {
    private  String nombreEquipo;
    private String paisOrigen;
    private  int anioFundacion;
    private String liga;
}
