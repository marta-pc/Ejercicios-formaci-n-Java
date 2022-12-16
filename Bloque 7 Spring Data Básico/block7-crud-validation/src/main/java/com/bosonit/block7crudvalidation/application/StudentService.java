package com.bosonit.block7crudvalidation.application;

import com.bosonit.block7crudvalidation.domain.entity.Student;
import com.bosonit.block7crudvalidation.domain.entity.Subject;

import java.util.List;

public interface StudentService {
    Student getById(int id);
    List<Student> getAll();
    void addStudent(Student student);
    void deleteById(int id);
    void updateStudent(int id, Student student);

    void addSubjects(List<Subject> subjects);

}
