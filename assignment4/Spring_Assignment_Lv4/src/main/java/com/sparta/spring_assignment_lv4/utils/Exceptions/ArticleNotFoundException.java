package com.sparta.spring_assignment_lv4.utils.Exceptions;

public class ArticleNotFoundException extends RuntimeException{
    public ArticleNotFoundException(String e) {
        super(e);
    }
}
