package mx.gendra.requests.repository;

import mx.gendra.requests.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAltaClienteRepository extends JpaRepository<Cliente, Long> {
}
