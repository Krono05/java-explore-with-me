package ru.practicum.ewm.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import ru.practicum.ewm.exception.model.ApiError;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

import static ru.practicum.ewm.util.Constants.*;

@RestControllerAdvice
@Slf4j
public class ExceptionApiHandler {

    @ExceptionHandler
    public ResponseEntity<ApiError> springValidationException(MethodArgumentNotValidException exception) {
        log.debug(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiError("BAD_REQUEST", "Incorrectly made request.",
                        exception.getMessage(), LocalDateTime.now().format(DATE_FORMAT)));
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiError> manualValidationException(ValidationException exception) {
        log.debug(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiError("BAD_REQUEST", "Invalid request.",
                        exception.getMessage(), LocalDateTime.now().format(DATE_FORMAT)));
    }

    @ExceptionHandler({InvalidFormatException.class, IllegalArgumentException.class})
    public ResponseEntity<ApiError> enumValidationException(RuntimeException exception) {
        log.debug(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiError("BAD_REQUEST", "Incorrectly made request.",
                        exception.getMessage(), LocalDateTime.now().format(DATE_FORMAT)));
    }

    @ExceptionHandler({CategoryNotFoundException.class,
            UserNotFoundException.class,
            CompilationNotFoundException.class,
            RequestNotFoundException.class,
            EventNotFoundException.class,
            CommentNotFoundException.class})
    public ResponseEntity<ApiError> objectNotFoundException(EntityNotFoundException exception) {
        log.debug(exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiError("NOT_FOUND", "The required object was not found.",
                exception.getMessage(), LocalDateTime.now().format(DATE_FORMAT)));
    }

    @ExceptionHandler
    public ResponseEntity<ApiError> constraintViolationException(ConstraintViolationException exception) {
        log.debug(exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ApiError("CONFLICT", "Integrity constraint has been violated.",
                        exception.getMessage(), LocalDateTime.now().format(DATE_FORMAT)));
    }

    @ExceptionHandler
    public ResponseEntity<ApiError> forbiddenException(ForbiddenException exception) {
        log.debug(exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ApiError("CONFLICT", "For the requested operation the conditions are not met.",
                        exception.getMessage(), LocalDateTime.now().format(DATE_FORMAT)));
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ApiError> handleMaxSizeException(MaxUploadSizeExceededException exception) {
        log.debug(exception.getMessage());
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                .body(new ApiError("EXPECTATION_FAILED", "Expectation given in the request's header could not be met.",
                        exception.getMessage(), LocalDateTime.now().format(DATE_FORMAT)));
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity<ApiError> handleUnsupportedFormatException(UnsupportedOperationException exception) {
        log.debug(exception.getMessage());
        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
                .body(new ApiError("UNSUPPORTED_MEDIA_TYPE", "The payload format is in an unsupported format.",
                        exception.getMessage(), LocalDateTime.now().format(DATE_FORMAT)));
    }
}
