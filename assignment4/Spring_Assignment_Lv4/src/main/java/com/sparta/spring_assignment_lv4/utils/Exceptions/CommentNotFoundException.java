package com.sparta.spring_assignment_lv4.utils.Exceptions;

public class CommentNotFoundException extends RuntimeException{
    public CommentNotFoundException(String e) {
        super(e);
    }
}
