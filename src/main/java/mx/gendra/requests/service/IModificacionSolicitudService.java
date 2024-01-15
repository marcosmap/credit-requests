package mx.gendra.requests.service;

import mx.gendra.requests.model.DispersionSolicitudRequest;
import mx.gendra.requests.model.DispersionSolicitudResponse;
import mx.gendra.requests.model.ModificacionSolicitudRequest;
import mx.gendra.requests.model.ModificacionSolicitudResponse;

/**
 * Interface for the service 'Modificacion y dispersion'.
 */
public interface IModificacionSolicitudService {
    /**
     * This method allows modified the status of a request.
     * @param request data of status
     * @return a message with the final result of the process (success or error)
     */
    ModificacionSolicitudResponse modificaSolicitud(ModificacionSolicitudRequest request);

    /**
     * This method allows modified the status of a request and create a new credit for the client registered.
     * @param request data to update the status and create the new credit
     * @return a message with the final result of the process (success or error)
     */
    DispersionSolicitudResponse dispersarSolicitud(DispersionSolicitudRequest request);
}
