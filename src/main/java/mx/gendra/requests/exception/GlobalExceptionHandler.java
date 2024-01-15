package mx.gendra.requests.exception;

import lombok.extern.slf4j.Slf4j;
import mx.gendra.requests.exception.model.ErrorDetailResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.Objects;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
        HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        var error = ErrorDetailResponse.builder()
                .status("400")
                .errorType("bad request")
                .message(Arrays.stream(ex.getDetailMessageArguments()).toArray()[1].toString())
                .detail(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
        HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        var error = ErrorDetailResponse.builder()
                .status("400")
                .errorType("bad request")
                .message("Some field is incorrect")
                .detail(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorDetailResponse> handleDataNotFoundException(DataNotFoundException ex) {
        var error = ErrorDetailResponse.builder()
                .status("404")
                .errorType("not found")
                .message(ex.getMessage())
                .detail("")
                .build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataNotValidException.class)
    public ResponseEntity<ErrorDetailResponse> handleDataNotValidException(DataNotValidException ex) {
        var error = ErrorDetailResponse.builder()
                .status("412")
                .errorType("data not valid to process")
                .message(ex.getMessage())
                .detail("")
                .build();
        return new ResponseEntity<>(error, HttpStatus.PRECONDITION_FAILED);
    }

}
