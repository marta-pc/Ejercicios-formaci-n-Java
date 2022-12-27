package com.bosonit.block11uploaddownloadfiles.domain.exception;

public class FileUploadException extends RuntimeException{

    public FileUploadException (String e) {
        super (e);
    }

    public FileUploadException (String e, Throwable cause) {
        super (e, cause);
    }
}
