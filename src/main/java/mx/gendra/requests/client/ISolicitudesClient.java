package mx.gendra.requests.client;

import mx.gendra.requests.client.model.EstatusClient;
import mx.gendra.requests.client.model.SolicitudClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "solicitudes-client", url = "http://localhost:3005")
public interface ISolicitudesClient {

    @GetMapping(path = "/solicitudes")
    SolicitudClient getAllSolicitudes();

    @GetMapping(path = "/estatus")
    EstatusClient getAllEstatus();

}
