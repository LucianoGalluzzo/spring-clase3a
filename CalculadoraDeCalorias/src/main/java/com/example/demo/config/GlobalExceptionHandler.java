package com.example.demo.config;

import com.example.demo.dto.ErrorDTO;
import com.example.demo.exceptionHandler.NotFoundIngredientException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value={NotFoundIngredientException.class})
    public ResponseEntity<ErrorDTO> notFoundIngredientException(NotFoundIngredientException e){
        ErrorDTO errorDTO = new ErrorDTO("Invalid Ingredient", e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
