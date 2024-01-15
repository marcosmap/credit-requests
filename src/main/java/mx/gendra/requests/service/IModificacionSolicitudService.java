package mx.gendra.requests.service;

import mx.gendra.requests.model.DispersionSolicitudRequest;
import mx.gendra.requests.model.DispersionSolicitudResponse;
import mx.gendra.requests.model.ModificacionSolicitudRequest;
import mx.gendra.requests.model.ModificacionSolicitudResponse;

public interface IModificacionSolicitudService {
    ModificacionSolicitudResponse modificaSolicitud(ModificacionSolicitudRequest request);
    DispersionSolicitudResponse dispersarSolicitud(DispersionSolicitudRequest request);
}
