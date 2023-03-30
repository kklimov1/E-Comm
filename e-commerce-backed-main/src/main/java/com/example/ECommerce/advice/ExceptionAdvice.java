package com.example.ECommerce.advice;
import com.example.ECommerce.exceptions.IncorrectLoginRequest;
import com.example.ECommerce.exceptions.UsernameTakenException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(IncorrectLoginRequest.class)
    public ResponseEntity handlerIncorrectLoginException(IncorrectLoginRequest e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(UsernameTakenException.class)
    public ResponseEntity handlerUsernameTakenException(UsernameTakenException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
