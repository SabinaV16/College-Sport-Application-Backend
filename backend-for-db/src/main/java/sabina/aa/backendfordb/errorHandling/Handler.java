package sabina.aa.backendfordb.errorHandling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class Handler extends RuntimeException {

    @ExceptionHandler(Exception.class)
    ResponseEntity<Object> handleInternal(Exception ex) {
        log.error(ex.getMessage());
        DefaultError defaultError = new DefaultError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name());
        return ResponseEntity.status(defaultError.status()).body(defaultError);
    }
}
