package mx.gendra.requests.service;

import mx.gendra.requests.model.AltaSolicitudRequest;
import mx.gendra.requests.model.AltaSolicitudResponse;
import mx.gendra.requests.model.Estatus;
import mx.gendra.requests.model.Motivo;
import mx.gendra.requests.repository.IAltaClienteRepository;
import mx.gendra.requests.repository.IAltaSolicitudRepository;
import mx.gendra.requests.repository.IEstatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;

/**
 * Service 'Alta de solicitud' class.
 */
@Service
public class AltaSolicitudService implements IAltaSolicitudService {

    /**
     * Inject repository AltaSolicitud dependency.
     */
    @Autowired
    private IAltaSolicitudRepository altaSolicitudRepository;
    /**
     * Inject repository ALtaCliente dependency.
     */
    @Autowired
    private IAltaClienteRepository clienteRepository;

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
