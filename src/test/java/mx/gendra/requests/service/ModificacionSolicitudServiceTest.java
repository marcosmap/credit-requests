package mx.gendra.requests.service;

import mx.gendra.requests.exception.DataNotFoundException;
import mx.gendra.requests.exception.DataNotValidException;
import mx.gendra.requests.model.Credito;
import mx.gendra.requests.model.DispersionSolicitudRequest;
import mx.gendra.requests.model.DispersionSolicitudResponse;
import mx.gendra.requests.model.Estatus;
import mx.gendra.requests.model.ModificacionSolicitudRequest;
import mx.gendra.requests.model.ModificacionSolicitudResponse;
import mx.gendra.requests.model.Solicitud;
import mx.gendra.requests.repository.IAltaSolicitudRepository;
import mx.gendra.requests.repository.ICreditoRepository;
import mx.gendra.requests.repository.IEstatusRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ModificacionSolicitudServiceTest {

    @Mock
    private IAltaSolicitudRepository solicitudRepository;
    @Mock
    private IEstatusRepository estatusRepository;
    @Mock
    private ICreditoRepository creditoRepository;
    @InjectMocks
    private ModificacionSolicitudService modificacionSolicitudService;

    @Test
    void testModificaSolicitud() {
        var request = ModificacionSolicitudRequest.builder()
                .idSolicitud("342342324")
                .build();
        Mockito.when(solicitudRepository.findById(Mockito.anyString())).thenReturn(Optional.of(new Solicitud()));
        ModificacionSolicitudResponse response = modificacionSolicitudService.modificaSolicitud(request);
        Assertions.assertNotNull(response);
    }

    @Test
    void testDispersarSolicitud() {
        var request = DispersionSolicitudRequest.builder()
                .idSolicitud("342342324")
                .build();
        Mockito.when(solicitudRepository.findById(Mockito.anyString())).thenReturn(Optional.of(new Solicitud()));
        Mockito.when(creditoRepository.save(Mockito.any())).thenReturn(new Credito());
        DispersionSolicitudResponse response = modificacionSolicitudService.dispersarSolicitud(request);
        Assertions.assertNotNull(response);
    }

    @Test
    void testDataNotFoundException() {
        var request = ModificacionSolicitudRequest.builder()
                .idSolicitud("342342324")
                .build();
        Mockito.when(solicitudRepository.findById(Mockito.anyString())).thenReturn(Optional.empty());
        Assertions.assertThrows(
                DataNotFoundException.class,
                () -> modificacionSolicitudService.modificaSolicitud(request)
        );
    }

    @Test
    void testDataNotValidException() {
        var request = ModificacionSolicitudRequest.builder()
                .idSolicitud("342342324")
                .build();
        var solicitud = Solicitud.builder()
                .idSolicitud("123456789012")
                .build();
        var estatus = Estatus.builder()
                .idEstatus("error")
                .fechaCambio("20240114")
                .build();
        Mockito.lenient().when(solicitudRepository.findById(Mockito.anyString())).thenReturn(Optional.of(solicitud));
        Mockito.lenient().when(estatusRepository.findBySolicitudIdSolicitud(Mockito.anyString())).thenReturn(Optional.of(estatus));
        Assertions.assertThrows(
                DataNotValidException.class,
                () -> modificacionSolicitudService.modificaSolicitud(request)
        );
    }

}
