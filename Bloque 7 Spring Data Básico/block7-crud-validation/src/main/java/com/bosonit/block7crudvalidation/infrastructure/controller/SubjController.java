package com.bosonit.block7crudvalidation.infrastructure.controller;


import com.bosonit.block7crudvalidation.application.SubjService;
import com.bosonit.block7crudvalidation.domain.entity.Subject;
import com.bosonit.block7crudvalidation.infrastructure.controller.dto.input.SubjInputDto;
import com.bosonit.block7crudvalidation.infrastructure.controller.dto.output.SubjOutputDto;
import com.bosonit.block7crudvalidation.infrastructure.mapper.SubjMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("asignaturas")
public class SubjController {
    private SubjService subjService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addSubject(@RequestBody SubjInputDto subjInputDto) {
        Subject subject =
                SubjMapper.INSTANCE.subjInputDtoToSubject(subjInputDto);
        subjService.addSubject(subject, subjInputDto.getStudentId());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deleteByStudent(@PathVariable int id) {
        subjService.deleteByStudent(id);
    }

    @PutMapping("{id}")
    public void updateSubj(@PathVariable int id, @RequestBody SubjInputDto subjInputDto) {
        Subject studentsStudies =
                SubjMapper.INSTANCE.subjInputDtoToSubject(subjInputDto);
        subjService.updateSubj(id, studentsStudies);
    }

    @GetMapping("{id}")
    public SubjOutputDto getById(@PathVariable int id) {
        Subject student = subjService.getById(id);
        return SubjMapper.INSTANCE.subjectToSubjOutputDto(student);
    }

    @GetMapping
    public List<SubjOutputDto> getAll() {
        List<Subject> studentsStudies = subjService.getAll();
        return studentsStudies.stream().map(SubjMapper.INSTANCE::subjectToSubjOutputDto).toList();
    }

    @GetMapping("estudiante")
    public List<SubjOutputDto> findByStudent(@RequestParam(value = "student_id") int studentId) {
        List<Subject> studentsStudies = subjService.findByStudent(studentId);
        return studentsStudies.stream().map(SubjMapper.INSTANCE::subjectToSubjOutputDto).toList();
    }
}
