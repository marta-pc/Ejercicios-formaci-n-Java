package com.bosonit.block11cors.infrastructure.controller.dto.input;

import lombok.Data;

@Data

public class StudentInputDto {
    PersonInputDto person;
    private String comments;
    private String Branch;
    ProfInputDto profesor;
}
