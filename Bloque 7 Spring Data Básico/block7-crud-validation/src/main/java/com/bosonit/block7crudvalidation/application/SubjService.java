package com.bosonit.block7crudvalidation.application;

import com.bosonit.block7crudvalidation.domain.entity.Profesor;
import com.bosonit.block7crudvalidation.domain.entity.Student;
import com.bosonit.block7crudvalidation.domain.entity.Subject;

import java.util.List;

public interface SubjService {
    Subject getById(int id);
    List<Subject> getAll();
    void addSubject(Subject subject, int id);
    void deleteByStudent(int studentId);
    void updateSubj(int id, Subject subject);
    List<Subject> findByStudent(int studentId);


}
