package mx.gendra.requests.repository;

import mx.gendra.requests.model.Estatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 'Estatus' repository.
 */
@Repository
public interface IEstatusRepository extends JpaRepository<Estatus, Long> {
    /**
     * Find a status by 'solicitudId'.
     * @param idSolicitud request's id
     * @return 'Estatus' object
     */
    Optional<Estatus> findBySolicitudIdSolicitud(String idSolicitud);
}
