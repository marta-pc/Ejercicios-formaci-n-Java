package com.bosonit.block7crudvalidation.infrastructure.controller.dto.input;

import lombok.Data;

@Data

public class StudentInputDto {
    private int personaId;
    private String comments;
    private String Branch;
    private int profesorId;
}
