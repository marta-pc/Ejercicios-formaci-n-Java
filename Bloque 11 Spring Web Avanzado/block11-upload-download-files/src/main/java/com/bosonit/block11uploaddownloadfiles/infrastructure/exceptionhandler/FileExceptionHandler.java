package com.bosonit.block11uploaddownloadfiles.infrastructure.exceptionhandler;

import com.bosonit.block11uploaddownloadfiles.domain.exception.FileNotFoundException;
import com.bosonit.block11uploaddownloadfiles.domain.exception.FileUploadException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

public class FileExceptionHandler extends ResponseEntityExceptionHandler {

    private FileError generateError(String message, HttpStatus httpStatus) {
        return FileError.builder()
                .message(message)
                .httpCode(httpStatus.value())
                .timestamp(LocalDate.now())
                .build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(FileNotFoundException.class)
    public FileError handleEntityNotFoundException(FileNotFoundException ex) {
        return generateError(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(FileUploadException.class)
    public FileError handleEntityNotFoundException(FileUploadException ex) {
        return generateError(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);

    }
}
