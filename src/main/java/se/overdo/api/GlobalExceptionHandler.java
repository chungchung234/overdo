package se.overdo.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponse<Void>> handleApiException(ApiException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        if (ex.getCode() == ErrorCode.TASK_NOT_FOUND) {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(
                ApiResponse.<Void>builder()
                        .success(false)
                        .message(ex.getMessage())
                        .build(),
                status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleException(Exception ex) {
        return new ResponseEntity<>(
                ApiResponse.<Void>builder()
                        .success(false)
                        .message("Internal Server Error")
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
