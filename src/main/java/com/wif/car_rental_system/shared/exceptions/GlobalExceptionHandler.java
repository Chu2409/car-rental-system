package com.wif.car_rental_system.shared.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.wif.car_rental_system.shared.dtos.ExceptionResDto;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceException;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<ExceptionResDto> handleEntityNotFound(
      Exception ex, WebRequest request) {

    ExceptionResDto exceptionRes = new ExceptionResDto(
        ex.getMessage(),
        request.getDescription(false).substring(4));

    return new ResponseEntity<>(exceptionRes, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(PersistenceException.class)
  public ResponseEntity<ExceptionResDto> handlePersistence(
      Exception ex, WebRequest request) {

    ExceptionResDto exceptionRes = new ExceptionResDto(
        ex.getMessage(),
        request.getDescription(false).substring(4));

    return new ResponseEntity<>(exceptionRes, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(EntityExistsException.class)
  public ResponseEntity<ExceptionResDto> handleEntityExists(
      Exception ex, WebRequest request) {

    ExceptionResDto exceptionRes = new ExceptionResDto(
        ex.getMessage(),
        request.getDescription(false).substring(4));

    return new ResponseEntity<>(exceptionRes, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({ ConstraintViolationException.class, DataIntegrityViolationException.class })
  public ResponseEntity<ExceptionResDto> handleConstraintViolation(
      Exception ex, WebRequest request) {

    ExceptionResDto exceptionRes = new ExceptionResDto(
        ex.getMessage(),
        request.getDescription(false).substring(4));

    return new ResponseEntity<>(exceptionRes, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ExceptionResDto> handleException(
      Exception ex, WebRequest request) {
    System.out.println(ex.getClass().getName());

    ExceptionResDto exceptionRes = new ExceptionResDto(
        ex.getMessage(),
        request.getDescription(false).substring(4));

    return new ResponseEntity<>(exceptionRes, HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
