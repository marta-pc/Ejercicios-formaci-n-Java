package com.bosonit.block7crudvalidation.application;

import com.bosonit.block7crudvalidation.domain.entity.Profesor;

import java.util.List;

public interface ProfService {
    Profesor getById(int id);
    List<Profesor> getAll();
    void addProf(Profesor profesor, int id);
    void deleteById(int id);
    void updateProf(int id, Profesor profesor);
}
