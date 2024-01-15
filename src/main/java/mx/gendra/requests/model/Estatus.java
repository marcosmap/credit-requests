package mx.gendra.requests.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
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
@Entity
@Table(name = "estatus")
public class Estatus implements Serializable {
    @Serial
    private static final long serialVersionUID = 2373720620775234773L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "estatus_desc")
    private String idEstatus;
    @Column(name = "fecha_cambio")
    private String fechaCambio;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "estatus_id")
    private List<Motivo> motivo;
    @OneToOne
    @JoinColumn(name = "solicitud_id")
    private Solicitud solicitud;
}
