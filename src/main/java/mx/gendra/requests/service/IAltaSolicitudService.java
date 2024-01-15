package mx.gendra.requests.service;

import mx.gendra.requests.model.AltaSolicitudRequest;
import mx.gendra.requests.model.AltaSolicitudResponse;

/**
 * Interface for the service 'Alta solicitud'.
 */
public interface IAltaSolicitudService {
    /**
     * This method allows the registration of a 'solicitud' and the 'client' that requested the new credit.
     * @param request data of client and request
     * @return a message with the final result of the process (success or error)
     */
    AltaSolicitudResponse altaSolicitud(AltaSolicitudRequest request);
}
