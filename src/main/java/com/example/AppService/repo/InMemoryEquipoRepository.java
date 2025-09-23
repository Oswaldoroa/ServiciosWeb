package com.example.AppService.repo;

import com.example.AppService.model.Equipo;
import org.springframework.stereotype.Repository;
import  java.util.*;
@Repository
public class InMemoryEquipoRepository implements EquipoRepository {

    private final Map<String, Equipo> equipos = new HashMap<>();

    @Override
    public List<Equipo> findAll() {
        return new ArrayList<>(equipos.values());
    }

    @Override
    public Optional<Equipo> findByNombreEquipo(String nombreEquipo) {
        return Optional.ofNullable(equipos.get(nombreEquipo));
    }

    @Override
    public Equipo save(Equipo e) {
        equipos.put(e.getNombreEquipo(), e);
        return e;
    }

    @Override
    public boolean deleteByNombreEquipo(String nombreEquipo) {
        return equipos.remove(nombreEquipo) != null;
    }
}
