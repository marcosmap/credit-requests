package mx.gendra.requests.client.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.gendra.requests.model.Estatus;

/**
 * Status client model.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstatusClient implements Serializable {
    /**
     * Serial id number.
     */
    @Serial
    private static final long serialVersionUID = -3861217002159820060L;
    /**
     * List of status from the external service.
     */
    private List<Estatus> estatuses;
}
