package com.bosonit.block11cors.application;

import com.bosonit.block11cors.domain.entity.Person;
import com.bosonit.block11cors.infrastructure.controller.dto.input.PersonInputDto;
import com.bosonit.block11cors.infrastructure.controller.dto.output.PersonOutputDto;

import java.util.List;

public interface PersonService {

    PersonOutputDto addPerson(PersonInputDto person);

    Person getPersonById(int id);

    void deletePersonById(int id);
    List<Person> getPeople();
    Person updatePerson(int id, Person person);
}

