package mx.gendra.requests.service;

import mx.gendra.requests.model.AltaSolicitudRequest;
import mx.gendra.requests.model.AltaSolicitudResponse;
import mx.gendra.requests.repository.IAltaClienteRepository;
import mx.gendra.requests.repository.IAltaSolicitudRepository;
import org.springframework.stereotype.Service;

/**
 * Service 'Alta de solicitud' class.
 */
@Service
public class AltaSolicitudService implements IAltaSolicitudService {

    /**
     * Inject repository AltaSolicitud dependency.
     */
    private IAltaSolicitudRepository altaSolicitudRepository;
    /**
     * Inject repository ALtaCliente dependency.
     */
    private IAltaClienteRepository clienteRepository;

    /**
     * Constructor for injection.
     * @param altaSolicitudRepository IAltaSolicitudRepository
     * @param clienteRepository IAltaClienteRepository
     */
    public AltaSolicitudService(IAltaSolicitudRepository altaSolicitudRepository, IAltaClienteRepository clienteRepository) {
        this.altaSolicitudRepository = altaSolicitudRepository;
        this.clienteRepository = clienteRepository;
    }

    /**
     * This method allows the registration of a 'solicitud' and the 'client' that requested the new credit.
     * @param request data of client and request
     * @return a message with the final result of the process (success or error)
     */
    @Override
    public AltaSolicitudResponse altaSolicitud(AltaSolicitudRequest request) {
        // save the client
        clienteRepository.save(request.getCliente());
        // set the client id to the request
        request.getSolicitud().setCliente(request.getCliente());
        // save the credit request
        altaSolicitudRepository.save(request.getSolicitud());
        // return response
        return AltaSolicitudResponse.builder()
                .message("Solicitud dada de alta")
                .build();
    }

}
