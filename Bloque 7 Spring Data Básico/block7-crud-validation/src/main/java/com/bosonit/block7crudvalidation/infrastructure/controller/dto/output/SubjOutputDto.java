package com.bosonit.block7crudvalidation.infrastructure.controller.dto.output;

import lombok.Data;

import java.util.Date;

@Data
public class SubjOutputDto {
    private int id;
    private String subject;
    private String comments;
    private Date initial_date;
}
