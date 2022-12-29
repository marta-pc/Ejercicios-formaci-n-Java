package com.bosonit.block7crudvalidation.infrastructure.controller.dto.input;

import lombok.Data;

@Data

public class StudentInputDto {
    int personId;
    private String comments;
    private String Branch;
    int profId;
}
