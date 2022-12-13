package com.bosonit.block7crudvalidation.application;

import com.bosonit.block7crudvalidation.infrastructure.controller.dto.output.PersonaOutputDto;
import com.bosonit.block7crudvalidation.domain.exception.EntityNotFoundException;
import com.bosonit.block7crudvalidation.domain.entity.Profesor;
import com.bosonit.block7crudvalidation.domain.repository.ProfRepository;
import com.bosonit.block7crudvalidation.domain.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class ProfServiceImp implements ProfService{

    private ProfRepository profRepository;
    private PersonaService personaService;
    private StudentRepository studentRepository;


    @Override
    public Profesor getById(String id) {
        Objects.requireNonNull(id);
        return profRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Id no encontrado"));
    }

    @Override
    public List<Profesor> getAll() {
        return profRepository.findAll();
    }

    @Override
    public void addProf(Profesor profesor, int personaId) {
        PersonaOutputDto persona = personaService.getPersonaById(personaId);
        if(persona.getStudent()!=null)
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public void updateProf(String id, Profesor profesor) {

    }
}
