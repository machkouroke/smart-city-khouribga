package com.lop.smartcitykhouribga.controllers;

import com.lop.smartcitykhouribga.models.Entities.DTO.ErrorMessage;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {
    /* Catch mutliple exceptions */

    @ExceptionHandler({AuthenticationException.class})
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleFlightNotFound(
            Exception e,
            WebRequest request) {



        ErrorMessage body = new ErrorMessage(
                HttpStatus.UNAUTHORIZED.value(),
                LocalDateTime.now(),
                e.getMessage(),
                e.getLocalizedMessage()
        );

        System.out.println(body);

        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }

}