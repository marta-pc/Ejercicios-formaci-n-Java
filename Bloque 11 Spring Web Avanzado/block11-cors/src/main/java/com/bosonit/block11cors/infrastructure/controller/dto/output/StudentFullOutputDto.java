package com.bosonit.block11cors.infrastructure.controller.dto.output;

import lombok.Data;

@Data
public class StudentFullOutputDto extends StudentOutputDto{
    private PersonOutputDto personOutputDto;
}
