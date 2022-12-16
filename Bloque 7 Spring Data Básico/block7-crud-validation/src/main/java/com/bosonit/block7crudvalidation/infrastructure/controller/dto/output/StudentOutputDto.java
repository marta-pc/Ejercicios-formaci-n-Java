package com.bosonit.block7crudvalidation.infrastructure.controller.dto.output;

import com.bosonit.block7crudvalidation.domain.entity.Subject;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StudentOutputDto {
    private int id;
    private String comments;
    private String branch;
    private List<Subject> studies = new ArrayList<>();

}
