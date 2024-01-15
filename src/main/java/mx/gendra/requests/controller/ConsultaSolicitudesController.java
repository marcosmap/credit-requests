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

import java.util.List;

@RestController
@RequestMapping(path = ResourceConstants.API_CONSULTA_PATH)
public class ConsultaSolicitudesController {

    @Autowired
    private ISolicitudesClient solicitudesClient;

    @GetMapping(path = ResourceConstants.API_CONSULTA_SOLICITUD_URI)
    public ResponseEntity<SolicitudClient> getSolicitudes() {
        return new ResponseEntity<>(solicitudesClient.getAllSolicitudes(), HttpStatus.OK);
    }

    @GetMapping(path = ResourceConstants.API_CONSULTA_ESTATUS_URI)
    public ResponseEntity<EstatusClient> getEstatus() {
        return new ResponseEntity<>(solicitudesClient.getAllEstatus(), HttpStatus.OK);
    }

}
