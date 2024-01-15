package mx.gendra.requests.repository;

import mx.gendra.requests.model.Credito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICreditoRepository extends JpaRepository<Credito, Long> {
}
