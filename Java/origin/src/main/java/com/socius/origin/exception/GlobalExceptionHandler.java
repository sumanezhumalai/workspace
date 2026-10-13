package com.socius.origin.exception;
import java.util.HashMap;
import java.util.Map;

import com.socius.origin.exception.custom.*;
import com.socius.origin.dto.response.ApiResponse;
import com.socius.origin.dto.response.ApiResponseBuilder;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * GlobalExceptionHandler
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleValidation(
        MethodArgumentNotValidException ex
    ) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
            .getFieldErrors()
            .forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
            );

        return ResponseEntity
            .badRequest()
            .body(
                ApiResponseBuilder.error(
                    "Validation Failed",
                    errors
                )
            );
    }

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleTaskNotFound
    (TaskNotFoundException ex){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(
                    ApiResponseBuilder.error(ex.getMessage(),null)
                );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<?>>
    handleIllegalArgument(
        IllegalAccessException ex)
    {
        return ResponseEntity
                .badRequest()
                .body(
                    ApiResponseBuilder.error(ex.getMessage(), null)
                );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse<?>>
    handleInvalidEnum(
        HttpMessageNotReadableException ex){

            return ResponseEntity
                        .badRequest()
                        .body(
                            ApiResponseBuilder.error("Invalid Value - priority must be one of HIGH, MEDIUM, NORMAL", null)
                        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>>
    handleUnknown(Exception ex)
    {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                    ApiResponseBuilder.error("Internal Server Error", null)
                );
    }
    
}
