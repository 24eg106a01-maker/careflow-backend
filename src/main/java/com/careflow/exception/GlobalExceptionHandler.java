package com.careflow.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<?> badRequest(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(Map.of("timestamp", LocalDateTime.now(), "status",400,"message",e.getMessage()));
    }
    @ExceptionHandler(IllegalStateException.class)
    ResponseEntity<?> conflict(IllegalStateException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("timestamp", LocalDateTime.now(), "status",409,"message",e.getMessage()));
    }
}
