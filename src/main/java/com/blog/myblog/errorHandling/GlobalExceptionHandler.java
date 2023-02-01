package com.blog.myblog.errorHandling;

import com.blog.myblog.exceptions.ArticleRatedByUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArticleRatedByUserException.class)
    public ResponseEntity<String> handle(ArticleRatedByUserException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.TEXT_PLAIN)
                .body(exception.getMessage());
    }
}
