package mx.gendra.requests.controller;

import jakarta.validation.Valid;
import mx.gendra.requests.model.DispersionSolicitudRequest;
import mx.gendra.requests.model.DispersionSolicitudResponse;
import mx.gendra.requests.model.ModificacionSolicitudRequest;
import mx.gendra.requests.model.ModificacionSolicitudResponse;
import mx.gendra.requests.service.IModificacionSolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/solicitudes")
public class ModificacionSolicitudController {

    @Autowired
    private IModificacionSolicitudService modificacionSolicitudService;

    @PostMapping(path = "/modificacion")
    public ResponseEntity<ModificacionSolicitudResponse> modificaSolicitud(
            @Valid @RequestBody ModificacionSolicitudRequest request) {
        return new ResponseEntity<>(modificacionSolicitudService.modificaSolicitud(request), HttpStatus.OK);
    }

    @PostMapping(path = "/dispersar")
    public ResponseEntity<DispersionSolicitudResponse> dispersarSolicitud(
            @Valid @RequestBody DispersionSolicitudRequest request) {
        return new ResponseEntity<>(modificacionSolicitudService.dispersarSolicitud(request), HttpStatus.OK);
    }

}