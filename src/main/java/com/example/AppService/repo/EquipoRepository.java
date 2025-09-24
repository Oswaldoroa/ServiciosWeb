package com.example.AppService.repo;
import com.example.AppService.model.Equipo;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EquipoRepository {
    List<Equipo> findAll();
    Optional<Equipo>findById(UUID Id);
    Equipo save (Equipo e);
    boolean deleteById(UUID Id);
}
