package mx.gendra.requests.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AltaSolicitudRequest {
    @NotEmpty(message = "Promotor no válido")
    private String promotor;
    @NotEmpty(message = "Empresa no válida")
    private String empresa;
    @Valid
    private Cliente cliente;
    @Valid
    private Solicitud solicitud;
}
