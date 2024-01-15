package mx.gendra.requests.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "creditos")
public class Credito implements Serializable {
    @Serial
    private static final long serialVersionUID = 4897041129241887669L;
    @Id
    @Column(name = "credito_id")
    private Long idCredito;
    @Column(name = "capital_dispersado")
    private Double capitalDispersado;
    @Column(name = "monto")
    private Double monto;
    @Column(name = "tasa")
    private Double tasa;
    @Column(name = "plazo")
    private Integer plazo;
    @Column(name = "frecuencia")
    private String frecuencia;
    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
