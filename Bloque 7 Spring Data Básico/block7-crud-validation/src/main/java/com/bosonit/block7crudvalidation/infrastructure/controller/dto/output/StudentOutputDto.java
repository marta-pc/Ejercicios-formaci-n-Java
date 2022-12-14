package com.bosonit.block7crudvalidation.infrastructure.controller.dto.output;

import com.bosonit.block7crudvalidation.domain.entity.Subject;

import java.util.ArrayList;
import java.util.List;

public class StudentOutputDto {
    private int idstudent;
    private String comments;
    private String branch;
    private List<Subject> studies = new ArrayList<>();

}
