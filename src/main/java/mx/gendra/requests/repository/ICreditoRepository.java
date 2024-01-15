package mx.gendra.requests.repository;

import mx.gendra.requests.model.Credito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 'Credito' repository.
 */
@Repository
public interface ICreditoRepository extends JpaRepository<Credito, Long> {
}
