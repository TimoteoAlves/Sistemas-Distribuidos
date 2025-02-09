package com.timoteo.API.CPF.CNPJ.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity<String> handleValidacaoException(ValidacaoException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}