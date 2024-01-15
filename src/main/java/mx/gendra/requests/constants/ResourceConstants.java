package mx.gendra.requests.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Class to read the properties values from the .properties file.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ResourceConstants {

    /**
     * Request's base path.
     */
    public static final String API_SOLICITUDES_PATH = "${requests.api.services.solicitudes.path}";
    /**
     * Request registration's endpoint.
     */
    public static final String API_SOLICITUDES_ALTA_URI = "${requests.api.services.solicitudes.alta.uri}";
    /**
     * Request modification's endpoint.
     */
    public static final String API_SOLICITUDES_MODIFICACION_URI = "${requests.api.services.solicitudes.modificacion.uri}";
    /**
     * Request dispersion's endpoint.
     */
    public static final String API_SOLICITUDES_DISPERSION_URI = "${requests.api.services.solicitudes.dispersar.uri}";
    /**
     * Query's base path.
     */
    public static final String API_CONSULTA_PATH = "${requests.api.services.consulta.path}";
    /**
     * Query request's base path.
     */
    public static final String API_CONSULTA_SOLICITUD_URI = "${requests.api.services.consulta.solicitudes.uri}";
    /**
     * Query status's base path.
     */
    public static final String API_CONSULTA_ESTATUS_URI = "${requests.api.services.consulta.estatus.uri}";
    /**
     * Client's base path.
     */
    public static final String EXTERNAL_CLIENT_BASE_PATH = "${client.external.base.url}";
    /**
     * Client's request uri.
     */
    public static final String EXTERNAL_CLIENT_REQUEST_URI = "${client.external.request.uri}";
    /**
     * Client's status uri.
     */
    public static final String EXTERNAL_CLIENT_STATUS_URI = "${client.external.status.uri}";
    /**
     * Client's name.
     */
    public static final String EXTERNAL_CLIENT_NAME = "${client.external.name}";

}
