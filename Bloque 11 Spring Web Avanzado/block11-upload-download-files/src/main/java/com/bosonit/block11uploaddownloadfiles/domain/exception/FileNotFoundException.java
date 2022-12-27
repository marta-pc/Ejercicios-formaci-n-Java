package com.bosonit.block11uploaddownloadfiles.domain.exception;

public class FileNotFoundException extends RuntimeException{

    public FileNotFoundException(String e) {
        super(e);
    }

    public FileNotFoundException(String e, Throwable cause) {
        super(e, cause);
    }
}
