package com.bosonit.block7crudvalidation.infrastructure.controller.dto.output;

import com.bosonit.block7crudvalidation.domain.entity.Student;
import lombok.Data;

import java.util.List;

@Data
public class ProfOutputDto {

    private int id;

    private String comments;

    private String branch;

    private List<Student> students;



}
