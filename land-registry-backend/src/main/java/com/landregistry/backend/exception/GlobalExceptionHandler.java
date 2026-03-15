package com.landregistry.backend.exception;

import com.landregistry.backend.response.ApiResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ApiResponse<String> handleNotFound(ResourceNotFoundException ex) {

        return new ApiResponse<>(
                false,
                ex.getMessage(),
                null
        );
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<String> handleGenericException(Exception ex) {

        return new ApiResponse<>(
                false,
                "Something went wrong",
                null
        );
    }
}