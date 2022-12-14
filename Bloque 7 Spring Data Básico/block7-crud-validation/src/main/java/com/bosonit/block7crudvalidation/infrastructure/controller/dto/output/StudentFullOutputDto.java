package com.bosonit.block7crudvalidation.infrastructure.controller.dto.output;

import lombok.Data;

@Data

public class StudentFullOutputDto extends StudentOutputDto{
    private PersonOutputDto personOutputDto;
}
