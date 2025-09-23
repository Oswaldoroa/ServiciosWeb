package com.example.AppService.controller;

import com.example.AppService.dto.EquipoRequest;
import com.example.AppService.dto.EquipoResponse;
import com.example.AppService.service.EquipoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipos")

public class EquipoController {
    private final EquipoService service;

    public EquipoController(EquipoService service) {
        this.service = service;
    }
    @GetMapping
    public List<EquipoResponse> listar() {
        return service.listar();
    }

    @GetMapping("/{nombreEquipo}")
    public EquipoResponse obtener(@PathVariable String nombreEquipo) {
        return service.obtener(nombreEquipo);
    }

    @PostMapping
    public EquipoResponse crear(@RequestBody EquipoRequest request) {
        return service.crear(request);
    }

    @PutMapping("/{nombreEquipo}")
    public EquipoResponse actualizar(
            @PathVariable String nombreEquipo,
            @RequestBody EquipoRequest request
    ) {
        return service.actualizar(nombreEquipo, request);
    }

    @DeleteMapping("/{nombreEquipo}")
    public ResponseEntity<Void> eliminar(@PathVariable String nombreEquipo) {
        service.eliminar(nombreEquipo);
        return ResponseEntity.noContent().build();
    }

}
