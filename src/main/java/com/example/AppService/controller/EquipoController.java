package com.example.AppService.controller;

import com.example.AppService.dto.EquipoRequest;
import com.example.AppService.dto.EquipoResponse;
import com.example.AppService.service.EquipoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/equipos")

public class EquipoController {
    private final EquipoService service;

    public EquipoController(EquipoService service) {
        this.service = service;
    }
    @GetMapping
    public List<EquipoResponse> listar() {
        return service.listar();
    }


    @GetMapping("/{id}")
    public ResponseEntity<EquipoResponse> obtener(@PathVariable UUID id) {
        return ResponseEntity.ok(service.obtener(id));
    }


    @PostMapping
    public ResponseEntity<EquipoResponse> crear(@RequestBody EquipoRequest request) {
        return ResponseEntity.ok(service.crear(request));
    }


    @PutMapping("/{id}")
    public ResponseEntity<EquipoResponse> actualizar(@PathVariable UUID id, @RequestBody EquipoRequest request) {
        return ResponseEntity.ok(service.actualizar(id, request));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable UUID id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
