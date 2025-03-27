package com.spring.service;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(Long id) {
        super("The Post with ID " + id + " doesn't exist. Failed update");
    }
}
