package mx.gendra.requests.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
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
public class ModificacionSolicitudRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 55637281022023296L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Id solicitud no válido")
    private String idSolicitud;
    @NotEmpty(message = "id estatus no válido")
    private String idEstatus;
    @Valid
    private List<Motivo> motivo;
    @NotNull(message = "fecha modificacion no válida")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    private LocalDate fechaCambio;
}
