package co.edu.ufps.previo.repository;

import co.edu.ufps.previo.model.clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clienteRepository extends JpaRepository<clientes, Long> {
    clientes findByEmail(String email);
}