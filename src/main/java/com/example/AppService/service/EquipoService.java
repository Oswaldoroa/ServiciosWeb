package com.example.AppService.service;

import com.example.AppService.dto.EquipoRequest;
import com.example.AppService.dto.EquipoResponse;
import com.example.AppService.model.Equipo;
import com.example.AppService.repo.EquipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service


public class EquipoService {

    private final EquipoRepository repo;
    public EquipoService(EquipoRepository repo){
        this.repo = repo;
    }

    //
    public List<EquipoResponse> listar(){
        return repo.findAll().stream().map(this::toResponse).toList();
    }

    //
    public EquipoResponse obtener(String nombreEquipo) {
        Equipo e = repo.findByNombreEquipo(nombreEquipo)
                .orElseThrow(() -> new IllegalArgumentException("Equipo no encontrado: " + nombreEquipo));
        return toResponse(e);
    }

    //
    public EquipoResponse crear(EquipoRequest req) {
        repo.findByNombreEquipo(req.nombreEquipo()).ifPresent(e -> {
            throw new IllegalArgumentException("Ya existe un equipo con ese nombre");
        });

        Equipo e = Equipo.builder()
                .nombreEquipo(req.nombreEquipo())
                .paisOrigen(req.paisOrigen())
                .anioFundacion(req.anioFundacion())
                .categoria(req.categoria())
                .liga(req.liga())
                .build();

        return toResponse(repo.save(e));
    }
    //
    public EquipoResponse actualizar(String nombreEquipo, EquipoRequest req) {
        Equipo existente = repo.findByNombreEquipo(nombreEquipo)
                .orElseThrow(() -> new IllegalArgumentException("Equipo no encontrado: " + nombreEquipo));

        if (!existente.getNombreEquipo().equalsIgnoreCase(req.nombreEquipo())) {
            repo.findByNombreEquipo(req.nombreEquipo()).ifPresent(e -> {
                throw new IllegalArgumentException("Ya existe un equipo con ese nombre");
            });
        }

        existente.setNombreEquipo(req.nombreEquipo());
        existente.setPaisOrigen(req.paisOrigen());
        existente.setAnioFundacion(req.anioFundacion());
        existente.setCategoria(req.categoria());
        existente.setLiga(req.liga());

        return toResponse(repo.save(existente));
    }
    //
    public void eliminar(String nombreEquipo) {
        if (!repo.deleteByNombreEquipo(nombreEquipo)) {
            throw new IllegalArgumentException("Equipo no encontrado: " + nombreEquipo);
        }
    }
    //
    private EquipoResponse toResponse(Equipo e) {
        return new EquipoResponse(
                e.getNombreEquipo(),
                e.getPaisOrigen(),
                e.getAnioFundacion(),
                e.getCategoria(),
                e.getLiga()
        );
    }

}
