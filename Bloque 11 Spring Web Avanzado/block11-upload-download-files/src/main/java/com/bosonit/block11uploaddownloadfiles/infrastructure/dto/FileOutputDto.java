package com.bosonit.block11uploaddownloadfiles.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder

public class FileOutputDto {

    private int id;

    private String name;

    private Date date;
}
