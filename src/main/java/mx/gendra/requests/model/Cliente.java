package mx.gendra.requests.model;

import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
    @Serial
    private static final long serialVersionUID = 475832927736897557L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Long id;
    @NotEmpty(message = "Nombre no válido")
    @Column(name = "nombre")
    private String nombre;
    @NotEmpty(message = "Aplliedo paterno no válido")
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @NotEmpty(message = "Apellido materno no válido")
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
}
