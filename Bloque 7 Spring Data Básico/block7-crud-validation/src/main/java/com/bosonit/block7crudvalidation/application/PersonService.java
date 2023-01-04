package com.bosonit.block7crudvalidation.application;

import com.bosonit.block7crudvalidation.domain.entity.Person;
import com.bosonit.block7crudvalidation.infrastructure.controller.dto.input.PersonInputDto;
import com.bosonit.block7crudvalidation.infrastructure.controller.dto.output.PersonOutputDto;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface PersonService {

    Person addPerson(Person person);

    Person getPersonById(int id);

    void deletePersonById(int id);
    List<Person> getPeople();
    Person updatePerson(int id, Person person);

    List<Person> getByFields(String usuario, String name, String surname, Date created_date, String orderBy, String dateCondition);

    Page<Person> getPeoplePagination (int offset, int pageSize);
}

