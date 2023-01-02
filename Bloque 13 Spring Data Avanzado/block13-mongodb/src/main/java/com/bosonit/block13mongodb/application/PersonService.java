package com.bosonit.block13mongodb.application;

import com.bosonit.block13mongodb.domain.entity.Person;
import org.springframework.data.domain.Page;


public interface PersonService {

    Person addPerson(Person person);

    Person findById(String id);

    void deleteById(String id);

    Person updatePerson(String id, Person person);

    Page<Person> getPeople (int offset, int pageSize);

}
