package com.bosonit.block7crudvalidation.infrastructure.controller;


import com.bosonit.block7crudvalidation.application.StudentService;
import com.bosonit.block7crudvalidation.domain.entity.Student;
import com.bosonit.block7crudvalidation.domain.entity.Subject;
import com.bosonit.block7crudvalidation.infrastructure.controller.dto.input.StudentInputDto;
import com.bosonit.block7crudvalidation.infrastructure.controller.dto.output.StudentOutputDto;
import com.bosonit.block7crudvalidation.infrastructure.mapper.StudentMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("estudiante")
@AllArgsConstructor
public class StudentController {
    private StudentService studentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addStudent(@RequestBody StudentInputDto studentInputDto){
        Student student = StudentMapper.INSTANCE.studentInputDtoToStudent(studentInputDto);
        studentService.addStudent(student, studentInputDto.getPersonaId(), studentInputDto.getProfesorId());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable int id) {
        studentService.deleteById(id);
    }

    @PutMapping("{id}")
    public void updateStudent(@PathVariable int id, @RequestBody StudentInputDto studentInputDto) {
        Student student = StudentMapper.INSTANCE.studentInputDtoToStudent(studentInputDto);
        studentService.getById(id);
    }

    @GetMapping("{id}")
    public StudentOutputDto getById(@PathVariable int id,
                                       @RequestParam(value = "ouputType", defaultValue = "simple") String ouputType) {
        Student student = studentService.getById(id);
        return (Objects.equals(ouputType, "simple")) ? StudentMapper.INSTANCE.studentToStudentOutputDto(student) :
                (Objects.equals(ouputType, "full")) ? StudentMapper.INSTANCE.studentToStudentFullOutputDto(student) :
                        null;
    }

    @GetMapping
    public List<StudentOutputDto> getAll() {
        List<Student> students = studentService.getAll();
        return students.stream().map(StudentMapper.INSTANCE::studentToStudentOutputDto).toList();
    }

    @PostMapping("asignaturas")
    public void addSubjects(List<Subject> studiesIds) {
        studentService.addSubjects(studiesIds);
    }
}
