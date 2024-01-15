package mx.gendra.requests.service;

import mx.gendra.requests.model.AltaSolicitudRequest;
import mx.gendra.requests.model.AltaSolicitudResponse;
import mx.gendra.requests.model.Cliente;
import mx.gendra.requests.model.Solicitud;
import mx.gendra.requests.repository.IAltaClienteRepository;
import mx.gendra.requests.repository.IAltaSolicitudRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AltaSolicitudServiceTest {

    @Mock
    private IAltaSolicitudRepository solicitudRepository;
    @Mock
    private IAltaClienteRepository clienteRepository;
    @InjectMocks
    private AltaSolicitudService solicitudService;

    @Test
    void testAltaSolicitud() {
        var request = AltaSolicitudRequest.builder()
                .solicitud(new Solicitud())
                .build();
        Mockito.when(clienteRepository.save(Mockito.any())).thenReturn(new Cliente());
        Mockito.when(solicitudRepository.save(Mockito.any())).thenReturn(new Solicitud());
        AltaSolicitudResponse response = solicitudService.altaSolicitud(request);
        Assertions.assertNotNull(response);
    }

}
