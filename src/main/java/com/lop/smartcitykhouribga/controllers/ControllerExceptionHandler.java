package com.lop.smartcitykhouribga.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
class CustomErrorMessage {
    private int statusCode;
    private LocalDateTime timestamp;
    private String message;
    private String description;

}

@ControllerAdvice
public class ControllerExceptionHandler  {

    @ExceptionHandler(HttpClientErrorException.Unauthorized.class)
    public ResponseEntity<CustomErrorMessage> handleUnauthorizedException(HttpClientErrorException.Unauthorized e) {
        CustomErrorMessage body = new CustomErrorMessage(
                HttpStatus.UNAUTHORIZED.value(),
                LocalDateTime.now(),
                e.getMessage(),
                e.getResponseBodyAsString()
        );
        System.out.println("Unauthorized");
        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }
}
