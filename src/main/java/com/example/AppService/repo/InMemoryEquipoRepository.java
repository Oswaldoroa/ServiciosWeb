package com.example.AppService.repo;

import com.example.AppService.model.Equipo;
import org.springframework.stereotype.Repository;
import  java.util.*;
@Repository
public class InMemoryEquipoRepository implements EquipoRepository {

    private final Map<UUID, Equipo> equipos = new HashMap<>();

    @Override
    public List<Equipo> findAll() {
        return new ArrayList<>(equipos.values());
    }

    @Override
    public Optional<Equipo> findById(UUID id) {
        return Optional.ofNullable(equipos.get(id));
    }

    @Override
    public Equipo save(Equipo equipo) {
        if (equipo.getId() == null) {
            equipo.setId(UUID.randomUUID());
        }
        equipos.put(equipo.getId(), equipo);
        return equipo;
    }

    @Override
    public boolean deleteById(UUID id) {
        return equipos.remove(id) != null;
    }
}
