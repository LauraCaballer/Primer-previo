package co.edu.ufps.previo.repository;

import co.edu.ufps.previo.model.reservas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<reservas, Long> {
    List<reservas> findByClienteId(Long clienteId);
    List<reservas> findByHabitacionId(Long habitacionId);
    List<reservas> findByFechaInicioBetween(LocalDate start, LocalDate end);
    List<reservas> findByActivaTrue();
}