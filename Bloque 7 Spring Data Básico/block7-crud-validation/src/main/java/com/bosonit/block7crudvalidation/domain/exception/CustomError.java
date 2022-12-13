package com.bosonit.block7crudvalidation.domain.exception;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class CustomError {
    Date timestamp;
    Integer httpCode;
    String message;
}
