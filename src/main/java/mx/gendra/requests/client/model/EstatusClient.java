package mx.gendra.requests.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.gendra.requests.model.Estatus;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstatusClient implements Serializable {
    @Serial
    private static final long serialVersionUID = -3861217002159820060L;
    private List<Estatus> estatuses;
}
