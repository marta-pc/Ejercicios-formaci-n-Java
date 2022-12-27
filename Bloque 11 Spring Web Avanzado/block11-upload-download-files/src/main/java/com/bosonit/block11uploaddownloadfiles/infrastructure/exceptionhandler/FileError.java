package com.bosonit.block11uploaddownloadfiles.infrastructure.exceptionhandler;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class FileError {
    LocalDate timestamp;
    Integer httpCode;
    String message;
}
