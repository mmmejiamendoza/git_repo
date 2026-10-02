package com.demo.spring.exceptions;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//import com.demo.spring.exceptions.StudentNotFoundException;

@RestControllerAdvice 
public class StudentExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<StudentErrorResponse> handleStudentNotFoundExceptions(StudentNotFoundException e) {
            StudentErrorResponse error = new StudentErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    /* @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StudentErrorResponse> handleValidationException(MethodArgumentNotValidException e) {
        StudentErrorResponse error = new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(), "Validation failed, check input", System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    } */

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StudentErrorResponse> handleValidationException(MethodArgumentNotValidException e) {
        String details = e.getBindingResult().getFieldErrors().stream()
        .map(error -> error.getField() + ":" + error.getDefaultMessage())
        .collect(Collectors.joining(":"));

        StudentErrorResponse error = new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(), details, System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StudentErrorResponse> handleGenericException(Exception e) {
        StudentErrorResponse error = new StudentErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "an internal error occureed", System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
