package com.example.AppService.service;

import com.example.AppService.dto.EquipoRequest;
import com.example.AppService.dto.EquipoResponse;
import com.example.AppService.model.Equipo;
import com.example.AppService.repo.EquipoRepository;
import org.springframework.stereotype.Service;
import  java.util.UUID;

import java.util.List;
@Service


public class EquipoService {

    private final EquipoRepository repo;

    public EquipoService(EquipoRepository repo) {
        this.repo = repo;
    }

    public List<EquipoResponse> listar() {
        return repo.findAll().stream().map(this::toResponse).toList();
    }

    public EquipoResponse obtener(UUID id) {
        Equipo e = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Equipo no encontrado: " + id));
        return toResponse(e);
    }

    public EquipoResponse crear(EquipoRequest req) {
        Equipo e = Equipo.builder()
                .nombreEquipo(req.nombreEquipo())
                .paisOrigen(req.paisOrigen())
                .anioFundacion(req.anioFundacion())
                .categoria(req.categoria())
                .liga(req.liga())
                .build();
        return toResponse(repo.save(e));
    }

    public EquipoResponse actualizar(UUID id, EquipoRequest req) {
        Equipo existente = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Equipo no encontrado: " + id));

        existente.setNombreEquipo(req.nombreEquipo());
        existente.setPaisOrigen(req.paisOrigen());
        existente.setAnioFundacion(req.anioFundacion());
        existente.setCategoria(req.categoria());
        existente.setLiga(req.liga());

        return toResponse(repo.save(existente));
    }

    public void eliminar(UUID id) {
        if (!repo.deleteById(id)) {
            throw new IllegalArgumentException("Equipo no encontrado: " + id);
        }
    }

    private EquipoResponse toResponse(Equipo e) {
        return new EquipoResponse(
                e.getId(),
                e.getNombreEquipo(),
                e.getPaisOrigen(),
                e.getAnioFundacion(),
                e.getCategoria(),
                e.getLiga()
        );
    }

}
