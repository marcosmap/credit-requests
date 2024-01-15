package mx.gendra.requests.controller;

import mx.gendra.requests.client.ISolicitudesClient;
import mx.gendra.requests.client.model.EstatusClient;
import mx.gendra.requests.client.model.SolicitudClient;
import mx.gendra.requests.constants.ResourceConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Query requests controller.
 */
@RestController
@RequestMapping(path = ResourceConstants.API_CONSULTA_PATH)
public class ConsultaSolicitudesController {

    /**
     * Inject service's dependency to consult the requests.
     */
    private ISolicitudesClient solicitudesClient;

    /**
     * Constructor.
     * @param solicitudesClient client
     */
    public ConsultaSolicitudesController(ISolicitudesClient solicitudesClient) {
        this.solicitudesClient = solicitudesClient;
    }

    /**
     * Method to recover all the requests existing on the service.
     * @return list of requests
     */
    @GetMapping(path = ResourceConstants.API_CONSULTA_SOLICITUD_URI)
    public ResponseEntity<SolicitudClient> getSolicitudes() {
        return new ResponseEntity<>(solicitudesClient.getAllSolicitudes(), HttpStatus.OK);
    }

    /**
     * Method to recover all the status existing on the service.
     * @return list of statuses
     */
    @GetMapping(path = ResourceConstants.API_CONSULTA_ESTATUS_URI)
    public ResponseEntity<EstatusClient> getEstatus() {
        return new ResponseEntity<>(solicitudesClient.getAllEstatus(), HttpStatus.OK);
    }

}
