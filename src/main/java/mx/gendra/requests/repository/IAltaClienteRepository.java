package mx.gendra.requests.repository;

import mx.gendra.requests.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 'Cliente' repository.
 */
@Repository
public interface IAltaClienteRepository extends JpaRepository<Cliente, Long> {
}
