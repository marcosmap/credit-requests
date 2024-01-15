package mx.gendra.requests.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
public class DispersionSolicitudResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = -5565657289893303757L;
    private String mensaje;
}
