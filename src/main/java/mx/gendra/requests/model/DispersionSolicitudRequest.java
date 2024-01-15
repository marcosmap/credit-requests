package mx.gendra.requests.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DispersionSolicitudRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = -1740744293305002456L;
    @NotEmpty(message = "idSolicitud no valido")
    private String idSolicitud;
    @NotNull(message = "idCredito no valido")
    private Long idCredito;
    @NotNull(message = "capitalDispersado no valido")
    private Double capitalDispersado;
    @NotNull(message = "monto no valido")
    private Double monto;
    @NotNull(message = "tasa no valido")
    private Double tasa;
    @NotNull(message = "plazo no valido")
    private Integer plazo;
    @NotEmpty(message = "frecuencia no valida")
    private String frecuencia;
}
