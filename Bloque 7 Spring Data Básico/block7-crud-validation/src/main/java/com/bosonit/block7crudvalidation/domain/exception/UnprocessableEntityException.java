package com.bosonit.block7crudvalidation.domain.exception;

public class UnprocessableEntityException extends RuntimeException{
    public UnprocessableEntityException(String msg) {
        super(msg);
    }
}
