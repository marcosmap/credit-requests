package mx.gendra.requests.repository;

import mx.gendra.requests.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAltaSolicitudRepository extends JpaRepository<Solicitud, String> {
}
