package mx.gendra.requests.exception;

import mx.gendra.requests.exception.model.ErrorDetailResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GlobalExceptionHandlerTest {

    @Mock
    private HttpMessageNotReadableException exception1;
    @Mock
    private HttpHeaders headers;
    @Mock
    private WebRequest webRequest;
    @InjectMocks
    private GlobalExceptionHandler handler;

    @Test
    void testHandleMethodArgumentNotValid() {
        ResponseEntity<Object> response = handler.handleHttpMessageNotReadable(exception1,
                headers, HttpStatusCode.valueOf(400), webRequest);
        Assertions.assertNotNull(response);
    }

    @Test
    void testHandleDataNotFoundException() {
        ResponseEntity<ErrorDetailResponse> response = handler.handleDataNotFoundException(new DataNotFoundException(""));
        Assertions.assertNotNull(response);
    }

    @Test
    void testHandleDataNotValidException() {
        ResponseEntity<ErrorDetailResponse> response = handler.handleDataNotValidException(new DataNotValidException(""));
        Assertions.assertNotNull(response);
    }

}
