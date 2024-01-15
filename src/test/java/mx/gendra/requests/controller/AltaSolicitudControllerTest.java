package mx.gendra.requests.controller;

import mx.gendra.requests.model.AltaSolicitudRequest;
import mx.gendra.requests.model.AltaSolicitudResponse;
import mx.gendra.requests.service.IAltaSolicitudService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AltaSolicitudControllerTest {

    @Mock
    private IAltaSolicitudService solicitudService;
    @InjectMocks
    private AltaSolicitudController altaSolicitudController;

    private static AltaSolicitudResponse altaSolicitudResponse;

    @BeforeEach
    void setUp() {
        altaSolicitudResponse = AltaSolicitudResponse.builder()
                .message("Solicitud dada de alta con éxito")
                .build();
    }

    @Test
    void testAltaSolicitud() {
        Mockito.when(solicitudService.altaSolicitud(Mockito.any())).thenReturn(altaSolicitudResponse);
        AltaSolicitudResponse response = altaSolicitudController.altaSolicitud(AltaSolicitudRequest.builder().build()).getBody();
        Assertions.assertNotNull(response);
    }

}
