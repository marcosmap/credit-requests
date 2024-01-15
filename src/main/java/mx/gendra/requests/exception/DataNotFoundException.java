package mx.gendra.requests.exception;

import java.io.Serial;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DataNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 574490705807907520L;

    public DataNotFoundException(String message) {
        super(message);
    }

}
