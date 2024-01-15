package mx.gendra.requests.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import jakarta.validation.constraints.Size;
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
@Entity
@Table(name = "solicitudes")
public class Solicitud implements Serializable {
    @Serial
    private static final long serialVersionUID = -8541312291407826023L;
    @Id
    @Column(name = "solicitud_id")
    @NotEmpty(message = "idSolicitud no válido")
    @Size(min = 12, max = 12)
    private String idSolicitud;
    @NotNull(message = "Monto no válido")
    @Column(name = "monto")
    private Double monto;
    @NotEmpty(message = "Producto no válido")
    @Column(name = "producto")
    private String producto;
    @NotNull(message = "Tipo de solicitud no válido")
    @Column(name = "tipo_solicitud_str")
    private String tipoSolicitudStr;
    @NotEmpty(message = "Id tipo de solicitud no válido")
    @Column(name = "id_tipo_solicitud")
    private String idTipoSolicitud;
    @NotNull(message = "Tasa no válida")
    @Column(name = "tasa")
    private Double tasa;
    @NotNull(message = "Plazo no válido")
    @Column(name = "plazo")
    private Integer plazo;
    @NotNull(message = "Frecuencia no válida")
    @Column(name = "frecuencia")
    private String frecuencia;
    @NotNull(message = "Fecha de solicitud no válida")
    @Column(name = "fecha_solicitud")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    private LocalDate fechaSolicitud;
    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
