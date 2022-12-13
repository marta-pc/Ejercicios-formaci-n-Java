package com.bosonit.block7crudvalidation.infrastructure.controller.dto.input;

import com.bosonit.block7crudvalidation.domain.entity.Persona;
import lombok.Data;

@Data

public class ProfInputDto {
    private String id;
    private String comments;
    private String branch;

}
