package com.bosonit.block11cors.application;

import com.bosonit.block11cors.domain.entity.Student;
import com.bosonit.block11cors.domain.entity.Subject;

import java.util.List;

public interface StudentService {
    Student getById(int id);
    List<Student> getAll();
    void addStudent(Student student);
    void deleteById(int id);
    void updateStudent(int id, Student student);

    void addSubjects(List<Subject> subjects);

}
