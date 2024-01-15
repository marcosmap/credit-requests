package mx.gendra.requests.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import mx.gendra.requests.client.ISolicitudesClient;
import mx.gendra.requests.exception.DataNotFoundException;
import mx.gendra.requests.exception.DataNotValidException;
import mx.gendra.requests.model.Credito;
import mx.gendra.requests.model.DispersionSolicitudRequest;
import mx.gendra.requests.model.DispersionSolicitudResponse;
import mx.gendra.requests.model.Estatus;
import mx.gendra.requests.model.ModificacionSolicitudRequest;
import mx.gendra.requests.model.ModificacionSolicitudResponse;
import mx.gendra.requests.model.Motivo;
import mx.gendra.requests.model.Solicitud;
import mx.gendra.requests.repository.IAltaSolicitudRepository;
import mx.gendra.requests.repository.ICreditoRepository;
import mx.gendra.requests.repository.IEstatusRepository;
import org.springframework.stereotype.Service;

/**
 * Service class to generate the update for modified and dispersion a request.
 */
@Slf4j
@Service
public class ModificacionSolicitudService implements IModificacionSolicitudService {

    /**
     * Inject repository AltaSolicitud dependency.
     */
    private IAltaSolicitudRepository solicitudRepository;
    /**
     * Inject repository Estatus dependency.
     */
    private IEstatusRepository estatusRepository;
    /**
     * Inject repository Credito dependency.
     */
    private ICreditoRepository creditoRepository;
    /**
     * Inject external client dependency.
     */
    private ISolicitudesClient solicitudesClient;

    /**
     * Constructor.
     * @param solicitudRepository IAltaSolicitudRepository
     * @param estatusRepository IEstatusRepository
     * @param creditoRepository ICreditoRepository
     * @param solicitudesClient ISolicitudesClient
     */
    public ModificacionSolicitudService(IAltaSolicitudRepository solicitudRepository,
                                        IEstatusRepository estatusRepository,
                                        ICreditoRepository creditoRepository,
                                        ISolicitudesClient solicitudesClient) {
        this.solicitudRepository = solicitudRepository;
        this.estatusRepository = estatusRepository;
        this.creditoRepository = creditoRepository;
        this.solicitudesClient = solicitudesClient;
    }

    /**
     * This method allows modified the status of a request.
     * @param request data of status
     * @return a message with the final result of the process (success or error)
     */
    @Override
    public ModificacionSolicitudResponse modificaSolicitud(ModificacionSolicitudRequest request) {
        // valida si la solicitud existe en credit-requests
        var solicitud = this.validaSiExisteSolicitud(request.getIdSolicitud());
        // valida si la solicitud eciste en logs con estatus error
        var estatus = this.validaSiExisteSolicitudLog(solicitud.get().getIdSolicitud());
        // actualiza estatus
        estatus.get().setIdEstatus(request.getIdEstatus());
        estatus.get().setSolicitud(solicitud.get());
        estatus.get().setMotivo(request.getMotivo());
        estatus.get().setFechaCambio(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        // save the new data
        estatusRepository.save(estatus.get());
        return ModificacionSolicitudResponse.builder()
                .mensaje("Solicitud modificada exitosamente")
                .build();
    }

    /**
     * This method allows modified the status of a request and create a new credit for the client registered.
     * @param request data to update the status and create the new credit
     * @return a message with the final result of the process (success or error)
     */
    @Override
    public DispersionSolicitudResponse dispersarSolicitud(DispersionSolicitudRequest request) {
        var idSolicitud = request.getIdSolicitud();
        // validate if the solicitud id provided exists
        var solicitud = this.validaSiExisteSolicitud(idSolicitud);
        // validate if status's request is 'error'
        var estatus = this.validaSiExisteSolicitudLog(idSolicitud);
        // update status
        estatus.get().setFechaCambio(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        estatus.get().setIdEstatus("DISPERSADO");
        estatus.get().setMotivo(
                Arrays.asList(
                        Motivo.builder()
                                .codigo("567")
                                .descripcion("Se dispersa la solicitud de crédito")
                                .build()
                )
        );
        // save the credit into the db
        var credito = Credito.builder()
                .idCredito(request.getIdCredito())
                .capitalDispersado(request.getCapitalDispersado())
                .monto(request.getMonto())
                .tasa(request.getTasa())
                .plazo(request.getPlazo())
                .frecuencia(request.getFrecuencia())
                .cliente(solicitud.get().getCliente())
                .build();
        creditoRepository.save(credito);
        // return response
        return DispersionSolicitudResponse.builder()
                .mensaje("Solicitud dispersada con éxito")
                .build();
    }

    /**
     * this method validates if the request exists to update its status.
     * @param idSolicitud request id
     * @return the request found or an error if not
     */
    private Optional<Solicitud> validaSiExisteSolicitud(String idSolicitud) {
        // se obtiene la solicitud
        var solicitudEncontrada = solicitudRepository.findById(idSolicitud);
        // valida si contiene informacion
        if (solicitudEncontrada.isEmpty()) {
            log.error("No se encontró la solicitud con id {}", idSolicitud);
            throw new DataNotFoundException("No se encontró la solicitud con id " + idSolicitud);
        }
        // retorna la solictud encontrada
        return solicitudEncontrada;
    }

    /**
     * this method validates if the request exists with an 'error' status to update it.
     * @param idSolicitud request id
     * @return the request found or an error if not
     */
    private Optional<Estatus> validaSiExisteSolicitudLog(String idSolicitud) {
        // valida si contiene estatus
        var estatus = estatusRepository.findBySolicitudIdSolicitud(idSolicitud);
        // si el estatus de la solicitud es 'error' no se puede seguir con el proceso de alta
        if (estatus.isEmpty()) {
            estatus = Optional.of(new Estatus());
        }
        else if (estatus.get().getIdEstatus().equals("error")) {
            log.error("Solicitud con id {} contiene estatus 'error' en log", idSolicitud);
            throw new DataNotValidException("Solicitud con id " + idSolicitud + " contiene estatus 'error' en log");
        }
        return estatus;
    }

}
