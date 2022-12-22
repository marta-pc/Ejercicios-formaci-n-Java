package com.bosonit.block11cors.application;

import com.bosonit.block11cors.domain.entity.Profesor;

import java.util.List;

public interface ProfService {
    Profesor getById(int id);
    List<Profesor> getAll();
    void addProf(Profesor profesor);
    void deleteById(int id);
    void updateProf(int id, Profesor profesor);
}
