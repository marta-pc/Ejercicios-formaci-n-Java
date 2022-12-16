package com.bosonit.block7crudvalidation.application;

import com.bosonit.block7crudvalidation.domain.entity.Person;
import com.bosonit.block7crudvalidation.infrastructure.controller.dto.input.PersonInputDto;
import com.bosonit.block7crudvalidation.infrastructure.controller.dto.output.PersonOutputDto;

import java.util.List;

public interface PersonService {

    PersonOutputDto addPerson(PersonInputDto person);

    Person getPersonById(int id);

    void deletePersonById(int id);
    List<Person> getPeople();
    Person updatePerson(int id, Person person);
}

