package com.bosonit.block11cors.infrastructure.mapper;

import com.bosonit.block11cors.domain.entity.Student;
import com.bosonit.block11cors.infrastructure.controller.dto.input.StudentInputDto;
import com.bosonit.block11cors.infrastructure.controller.dto.output.StudentOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    Student studentInputDtoToStudent(StudentInputDto studentInputDto);

    StudentOutputDto studentToStudentOutputDto(Student student);

    StudentOutputDto studentToStudentFullOutputDto(Student student);
}
