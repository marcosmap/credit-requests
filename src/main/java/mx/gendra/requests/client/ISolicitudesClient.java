package mx.gendra.requests.client;

import mx.gendra.requests.client.model.EstatusClient;
import mx.gendra.requests.client.model.SolicitudClient;
import mx.gendra.requests.constants.ResourceConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Client's interface to connect with the external services.
 */
@FeignClient(name = ResourceConstants.EXTERNAL_CLIENT_NAME, url = ResourceConstants.EXTERNAL_CLIENT_BASE_PATH)
public interface ISolicitudesClient {

    @GetMapping(path = ResourceConstants.EXTERNAL_CLIENT_REQUEST_URI)
    SolicitudClient getAllSolicitudes();

    @GetMapping(path = ResourceConstants.EXTERNAL_CLIENT_STATUS_URI)
    EstatusClient getAllEstatus();

}
