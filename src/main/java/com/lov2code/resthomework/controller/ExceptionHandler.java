package com.lov2code.resthomework.controller;

import com.lov2code.resthomework.exception.DataNotFoundException;
import com.lov2code.resthomework.exception.InvalidDataException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionHandler {

  @org.springframework.web.bind.annotation.ExceptionHandler(DataNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<String> handleDataNotFoundException(HttpServletRequest request, Exception ex)
  {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body("status:failed" + ex.getMessage());
  }

  @org.springframework.web.bind.annotation.ExceptionHandler(InvalidDataException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public void handlInvalidData(HttpServletRequest request, Exception ex)
  {
    System.out.println("jabsdokasd");
//    return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON).body("status:failed" + ex.getMessage());
  }
}
