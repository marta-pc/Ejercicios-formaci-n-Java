package com.example.block7crud.application;

import com.example.block7crud.controller.dto.PersonInputDto;
import com.example.block7crud.controller.dto.PersonOutputDto;

import java.util.List;

public interface PersonService {

    PersonOutputDto addPerson(PersonInputDto person);
    PersonOutputDto getPersonById(int id);
    PersonOutputDto getPersonByNombre(String nombre);
    void deletePersonById(int id);
    List<PersonOutputDto> getPeople();
    PersonOutputDto updatePerson(PersonInputDto person);
}

