package com.wif.car_rental_system.shared.exceptions;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.wif.car_rental_system.shared.dtos.ExceptionResDto;

@ControllerAdvice
public class GlobalExceptionHandler {

  // @ExceptionHandler(EntityNotFoundException.class)
  // public ResponseEntity<ExceptionResDto> handleEntityNotFound(
  // Exception ex, WebRequest request) {

  // ExceptionResDto exceptionRes = new ExceptionResDto(
  // ex.getMessage(),
  // request.getDescription(false).substring(4));

  // return new ResponseEntity<>(exceptionRes, HttpStatus.NOT_FOUND);
  // }

  // @ExceptionHandler(PersistenceException.class)
  // public ResponseEntity<ExceptionResDto> handlePersistence(
  // Exception ex, WebRequest request) {

  // ExceptionResDto exceptionRes = new ExceptionResDto(
  // ex.getMessage(),
  // request.getDescription(false).substring(4));

  // return new ResponseEntity<>(exceptionRes, HttpStatus.NOT_FOUND);
  // }

  // @ExceptionHandler(EntityExistsException.class)
  // public ResponseEntity<ExceptionResDto> handleEntityExists(
  // Exception ex, WebRequest request) {

  // ExceptionResDto exceptionRes = new ExceptionResDto(
  // ex.getMessage(),
  // request.getDescription(false).substring(4));

  // return new ResponseEntity<>(exceptionRes, HttpStatus.BAD_REQUEST);
  // }

  // @ExceptionHandler({ ConstraintViolationException.class,
  // DataIntegrityViolationException.class })
  // public ResponseEntity<ExceptionResDto> handleConstraintViolation(
  // Exception ex, WebRequest request) {

  // ExceptionResDto exceptionRes = new ExceptionResDto(
  // ex.getMessage(),
  // request.getDescription(false).substring(4));

  // return new ResponseEntity<>(exceptionRes, HttpStatus.BAD_REQUEST);
  // }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ExceptionResDto> handleConstraintViolation(
      MethodArgumentNotValidException ex, WebRequest request) {

    var errors = ex.getBindingResult().getFieldErrors().stream()
        .map(err -> err.getDefaultMessage()).collect(Collectors.toList());

    ExceptionResDto exceptionRes = new ExceptionResDto(
        "Errores de validación: " + errors,
        request.getDescription(false).substring(4));

    return new ResponseEntity<>(exceptionRes, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<ExceptionResDto> handleConstraintViolation(
      HttpMessageNotReadableException ex, WebRequest request) {

    ExceptionResDto exceptionRes = new ExceptionResDto(
        "Error en el cuerpo de la petición: " + ex.getMessage().split(":")[0],
        request.getDescription(false).substring(4));

    return new ResponseEntity<>(exceptionRes, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ExceptionResDto> handleException(
      Exception ex, WebRequest request) {
    System.out.println("Error Class: " + ex.getClass().getName());

    ExceptionResDto exceptionRes = new ExceptionResDto(
        ex.getMessage(),
        request.getDescription(false).substring(4));

    return new ResponseEntity<>(exceptionRes, HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
