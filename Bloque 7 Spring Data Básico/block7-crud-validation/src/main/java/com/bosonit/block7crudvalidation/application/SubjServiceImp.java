package com.bosonit.block7crudvalidation.application;

import com.bosonit.block7crudvalidation.domain.entity.Student;
import com.bosonit.block7crudvalidation.domain.entity.Subject;
import com.bosonit.block7crudvalidation.domain.exception.EntityNotFoundException;
import com.bosonit.block7crudvalidation.domain.repository.SubjRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SubjServiceImp implements SubjService {

    private  StudentService studentService;
    private SubjRepository subjRepository;
    @Override
    public Subject getById(int id) {
        return subjRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID no encontrada"));
    }

    @Override
    public List<Subject> getAll() {
        return subjRepository.findAll();
    }

    @Override
    public void addSubject(Subject subject, int studentId) {
        Student student = studentService.getById(studentId);
        subject.setStudent(student);
        List<Subject> studies = student.getStudies();
        studies.add(subject);
        student.setStudies(studies);
        subjRepository.save(subject);
        studentService.updateStudent(student.getId(), student);
    }

    @Override
    public void deleteByStudent(int studentId) {
        List<Subject> studies = subjRepository.getByStudentId(studentId);
        studies.forEach(study -> subjRepository.deleteById(study.getId()));
    }

    @Override
    public void updateSubj(int id, Subject subject) {
        this.getById(id);
        subjRepository.save(subject);
    }

    @Override
    public List<Subject> findByStudent(int studentId) {
        return subjRepository.getByStudentId(studentId);
    }
}
