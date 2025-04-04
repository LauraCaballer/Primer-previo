package co.edu.ufps.previo.repository;

import co.edu.ufps.previo.model.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {
    List<Habitacion> findByTipo(String tipo);
    List<Habitacion> findByCapacidadGreaterThanEqual(int capacidad);
    List<Habitacion> findByDisponibleTrue();
}