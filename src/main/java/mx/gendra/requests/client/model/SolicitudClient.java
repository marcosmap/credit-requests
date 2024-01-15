package mx.gendra.requests.client.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.gendra.requests.model.Solicitud;

/**
 * Request client model.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudClient implements Serializable {
    /**
     * Serial id number.
     */
    @Serial
    private static final long serialVersionUID = 2883851239089322926L;
    /**
     * List of Request to recover from the external service.
     */
    private List<Solicitud> solicitudes;
}
