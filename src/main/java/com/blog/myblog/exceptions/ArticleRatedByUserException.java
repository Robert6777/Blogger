package com.blog.myblog.exceptions;

public class ArticleRatedByUserException extends RuntimeException{

    public ArticleRatedByUserException(String message) {
        super(message);
    }
}
