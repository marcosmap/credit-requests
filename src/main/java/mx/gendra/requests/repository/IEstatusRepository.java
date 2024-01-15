package mx.gendra.requests.repository;

import mx.gendra.requests.model.Estatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEstatusRepository extends JpaRepository<Estatus, Long> {
    Optional<Estatus> findBySolicitudIdSolicitud(String idSolicitud);
}
