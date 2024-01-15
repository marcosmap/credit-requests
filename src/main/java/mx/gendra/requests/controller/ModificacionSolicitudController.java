package mx.gendra.requests.controller;

import jakarta.validation.Valid;
import mx.gendra.requests.constants.ResourceConstants;
import mx.gendra.requests.model.DispersionSolicitudRequest;
import mx.gendra.requests.model.DispersionSolicitudResponse;
import mx.gendra.requests.model.ModificacionSolicitudRequest;
import mx.gendra.requests.model.ModificacionSolicitudResponse;
import mx.gendra.requests.service.IModificacionSolicitudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Modification and dispersion controller.
 */
@RestController
@RequestMapping(path = ResourceConstants.API_SOLICITUDES_PATH)
public class ModificacionSolicitudController {

    /**
     * Inject service's dependency to consult the requests.
     */
    private IModificacionSolicitudService modificacionSolicitudService;

    /**
     * Constructor.
     * @param modificacionSolicitudService modified service
     */
    public ModificacionSolicitudController(IModificacionSolicitudService modificacionSolicitudService) {
        this.modificacionSolicitudService = modificacionSolicitudService;
    }

    /**
     * Method to update the status of a request.
     * @param request data for the status to update
     * @return a message with the final result of the process (success or error)
     */
    @PostMapping(path = ResourceConstants.API_SOLICITUDES_MODIFICACION_URI)
    public ResponseEntity<ModificacionSolicitudResponse> modificaSolicitud(
            @Valid @RequestBody ModificacionSolicitudRequest request) {
        return new ResponseEntity<>(modificacionSolicitudService.modificaSolicitud(request), HttpStatus.OK);
    }

    /**
     * Method to update the status of a request and generate a new credit.
     * @param request data for the status to update and the creation of a new credit
     * @return a message with the final result of the process (success or error)
     */
    @PostMapping(path = ResourceConstants.API_SOLICITUDES_DISPERSION_URI)
    public ResponseEntity<DispersionSolicitudResponse> dispersarSolicitud(
            @Valid @RequestBody DispersionSolicitudRequest request) {
        return new ResponseEntity<>(modificacionSolicitudService.dispersarSolicitud(request), HttpStatus.OK);
    }

}
