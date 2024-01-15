package mx.gendra.requests.controller;

import mx.gendra.requests.client.ISolicitudesClient;
import mx.gendra.requests.client.model.EstatusClient;
import mx.gendra.requests.client.model.SolicitudClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ConsultaSolicitudesControllerTest {

    @Mock
    private ISolicitudesClient solicitudesClient;
    @InjectMocks
    private ConsultaSolicitudesController controller;

    @Test
    void testGetSolicitudes() {
        Mockito.when(solicitudesClient.getAllSolicitudes()).thenReturn(new SolicitudClient());
        SolicitudClient response = controller.getSolicitudes().getBody();
        Assertions.assertNotNull(response);
    }

    @Test
    void testGetEstatus() {
        Mockito.when(solicitudesClient.getAllEstatus()).thenReturn(new EstatusClient());
        EstatusClient response = controller.getEstatus().getBody();
        Assertions.assertNotNull(response);
    }

}
