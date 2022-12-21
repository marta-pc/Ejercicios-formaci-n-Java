package com.example.block10dockerizeapp.application;

import com.example.block10dockerizeapp.controller.dto.PersonInputDto;
import com.example.block10dockerizeapp.controller.dto.PersonOutputDto;

import java.util.List;

public interface PersonService {

    PersonOutputDto addPerson(PersonInputDto person);
    PersonOutputDto getPersonById(int id);
    PersonOutputDto getPersonByNombre(String nombre);
    void deletePersonById(int id);
    List<PersonOutputDto> getPeople();
    PersonOutputDto updatePerson(PersonInputDto person);
}

