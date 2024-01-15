package mx.gendra.requests.controller;

import jakarta.validation.Valid;
import mx.gendra.requests.constants.ResourceConstants;
import mx.gendra.requests.model.AltaSolicitudRequest;
import mx.gendra.requests.model.AltaSolicitudResponse;
import mx.gendra.requests.service.IAltaSolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ResourceConstants.API_SOLICITUDES_PATH)
public class AltaSolicitudController {

    @Autowired
    private IAltaSolicitudService altaSolicitudService;

    @PostMapping(path = ResourceConstants.API_SOLICITUDES_ALTA_URI, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AltaSolicitudResponse> altaSolicitud(@Valid @RequestBody AltaSolicitudRequest request) {
        return new ResponseEntity<>(altaSolicitudService.altaSolicitud(request), HttpStatus.OK);
    }

}
