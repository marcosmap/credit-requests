package mx.gendra.requests.exception.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorDetailResponse {
    private String status;
    private String errorType;
    private String message;
    private String detail;
}
