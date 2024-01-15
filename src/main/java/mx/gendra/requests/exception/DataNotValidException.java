package mx.gendra.requests.exception;

import java.io.Serial;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class DataNotValidException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -941153247399170360L;

    public DataNotValidException(String message) {
        super(message);
    }

}
