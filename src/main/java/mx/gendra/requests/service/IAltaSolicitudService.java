package mx.gendra.requests.service;

import mx.gendra.requests.model.AltaSolicitudRequest;
import mx.gendra.requests.model.AltaSolicitudResponse;

public interface IAltaSolicitudService {
    AltaSolicitudResponse altaSolicitud(AltaSolicitudRequest request);
}
