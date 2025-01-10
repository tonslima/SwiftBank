package br.com.swiftbank.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Void> error404Handler(){

        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<FieldErrorDTO>> error400Handler(MethodArgumentNotValidException e){
        var errors = e.getFieldErrors();

        return ResponseEntity.badRequest().body(errors.stream().map(FieldErrorDTO::new).toList());
    }

    private record FieldErrorDTO(String field, String message){

        public FieldErrorDTO(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<String> error409Handler(SQLIntegrityConstraintViolationException e){
        var error = e.getMessage();

        return ResponseEntity.status(409).body(error);
    }

}


