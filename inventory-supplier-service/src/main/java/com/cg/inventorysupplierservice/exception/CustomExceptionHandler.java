/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-09-20 01:36:37
 * @modify date 2020-09-20 01:36:37
 * @desc Defines all exception handler
 */
package com.cg.inventorysupplierservice.exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {

        List<FieldErrorResponse> response = new ArrayList<>();
        ex.getBindingResult()
            .getAllErrors()
            .forEach(error -> {
                response.add(FieldErrorResponse.builder()
                    .field(((FieldError) error).getField())
                    .message(error.getDefaultMessage()).build());
        });

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ErrorResponse.builder()
                .timeStamp(System.currentTimeMillis())
                .status(HttpStatus.BAD_REQUEST.value())
                .message("FieldException")
                .errors(response)
                .build());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleInvalidCredential(NotFoundException ex) {

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ErrorResponse.builder()
                .timeStamp(System.currentTimeMillis())
                .status(HttpStatus.BAD_REQUEST.value()).message("FieldException")
                .errors(Collections.singletonList(FieldErrorResponse.builder()
                    .field(ex.getErrorName())
                    .message(ex.getErrorDescription())
                    .build())).build());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> catchAllException(Exception exception) {
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ErrorResponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(exception.getMessage())
                .timeStamp(System.currentTimeMillis()).build());
    }

}
