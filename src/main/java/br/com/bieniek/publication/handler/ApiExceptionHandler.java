package br.com.bieniek.publication.handler;

import br.com.bieniek.publication.domain.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handlerMethodException(
            final Exception exception, final HttpServletRequest request) {

        var error = ErrorResponse.builder()
                .timestamp(System.currentTimeMillis())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(exception.getMessage())
                .path(request.getRequestURI())
                .build();

        log.error("[Error] payload = {}", error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);

    }
}
