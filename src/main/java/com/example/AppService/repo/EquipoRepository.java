package com.example.AppService.repo;
import com.example.AppService.model.Equipo;
import java.util.List;
import java.util.Optional;

public interface EquipoRepository {
    List<Equipo> findAll();
    Optional<Equipo>findByNombreEquipo(String nombreEquipo);
    Equipo save (Equipo e);
    boolean deleteByNombreEquipo(String nombreEquipo);
}
