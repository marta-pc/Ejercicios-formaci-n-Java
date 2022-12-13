package com.bosonit.block7crudvalidation.domain.exception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String msg) {
        super(msg);
    }
}
