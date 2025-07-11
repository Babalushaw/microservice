package com.microservice.user.exception;

import com.microservice.user.payload.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){
        String message= ex.getMessage();
        APIResponse response=new APIResponse();
        response.setMessages(message);
        response.setStatus(HttpStatus.NOT_FOUND);
        response.setSuccess(true);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
