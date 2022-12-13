package com.bosonit.block7crudvalidation.application;

import com.bosonit.block7crudvalidation.domain.entity.Profesor;

import java.util.List;

public interface ProfService {
    Profesor getById(String id);
    List<Profesor> getAll();
    void addProf(Profesor profesor, int personaId);
    void deleteById(String id);
    void updateProf(String id, Profesor profesor);
}
