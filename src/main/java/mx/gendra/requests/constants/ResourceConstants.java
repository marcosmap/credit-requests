package mx.gendra.requests.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ResourceConstants {

    public static final String API_SOLICITUDES_PATH = "${requests.api.services.solicitudes.path}";
    public static final String API_SOLICITUDES_ALTA_URI = "${requests.api.services.solicitudes.alta.uri}";
    public static final String API_SOLICITUDES_MODIFICACION_URI = "${requests.api.services.solicitudes.modificacion.uri}";
    public static final String API_SOLICITUDES_DISPERSION_URI = "${requests.api.services.solicitudes.dispersar.uri}";
    public static final String API_CONSULTA_PATH = "${requests.api.services.consulta.path}";
    public static final String API_CONSULTA_SOLICITUD_URI = "${requests.api.services.consulta.solicitudes.uri}";
    public static final String API_CONSULTA_ESTATUS_URI = "${requests.api.services.consulta.estatus.uri}";

}
