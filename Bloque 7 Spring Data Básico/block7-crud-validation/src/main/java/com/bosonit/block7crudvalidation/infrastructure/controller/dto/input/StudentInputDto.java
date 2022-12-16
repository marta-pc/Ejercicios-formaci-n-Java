package com.bosonit.block7crudvalidation.infrastructure.controller.dto.input;

import lombok.Data;

@Data

public class StudentInputDto {
    PersonInputDto person;
    private String comments;
    private String Branch;
    ProfInputDto profesor;
}
