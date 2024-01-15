package mx.gendra.requests.controller;

import mx.gendra.requests.model.DispersionSolicitudRequest;
import mx.gendra.requests.model.DispersionSolicitudResponse;
import mx.gendra.requests.model.ModificacionSolicitudRequest;
import mx.gendra.requests.model.ModificacionSolicitudResponse;
import mx.gendra.requests.service.IModificacionSolicitudService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ModificacionSolicitudControllerTest {

    @Mock
    private IModificacionSolicitudService modificacionSolicitudService;
    @InjectMocks
    private ModificacionSolicitudController modificacionSolicitudController;

    private static ModificacionSolicitudResponse modificacionSolicitudResponse;
    private static DispersionSolicitudResponse dispersionSolicitudResponse;

    @BeforeAll
    static void beforeAll() {
        modificacionSolicitudResponse = ModificacionSolicitudResponse.builder()
                .mensaje("Solicitud modificada con éxito")
                .build();
        dispersionSolicitudResponse = DispersionSolicitudResponse.builder()
                .mensaje("Solicitud dispersada con éxito")
                .build();
    }

    @Test
    void testModificaSolicitud() {
        Mockito.when(modificacionSolicitudService.modificaSolicitud(Mockito.any())).thenReturn(modificacionSolicitudResponse);
        ModificacionSolicitudResponse response = modificacionSolicitudController.modificaSolicitud(new ModificacionSolicitudRequest()).getBody();
        Assertions.assertNotNull(response);
    }

    @Test
    void testDispersarSolicitud() {
        Mockito.when(modificacionSolicitudService.dispersarSolicitud(Mockito.any())).thenReturn(dispersionSolicitudResponse);
        DispersionSolicitudResponse response = modificacionSolicitudController.dispersarSolicitud(new DispersionSolicitudRequest()).getBody();
        Assertions.assertNotNull(response);
    }

}
