package com.bosonit.block11cors.application;

import com.bosonit.block11cors.domain.entity.Profesor;
import com.bosonit.block11cors.domain.entity.Student;
import com.bosonit.block11cors.domain.entity.Subject;

import java.util.List;

public interface SubjService {
    Subject getById(int id);
    List<Subject> getAll();
    void addSubject(Subject subject, int id);
    void deleteByStudent(int studentId);
    void updateSubj(int id, Subject subject);
    List<Subject> findByStudent(int studentId);


}
