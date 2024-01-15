package mx.gendra.requests.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serial;
import java.io.Serializable;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "motivos")
public class Motivo implements Serializable {
    @Serial
    private static final long serialVersionUID = -4813716462050491072L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Codigo no válido")
    private String codigo;
    @NotEmpty(message = "descripcion no válida")
    private String descripcion;
}
