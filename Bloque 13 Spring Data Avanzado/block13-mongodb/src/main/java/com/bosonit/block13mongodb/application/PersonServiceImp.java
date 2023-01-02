package com.bosonit.block13mongodb.application;

import com.bosonit.block13mongodb.domain.entity.Person;
import com.bosonit.block13mongodb.domain.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PersonServiceImp implements PersonService{

    private PersonRepository personRepository;

    @Override
    public Person addPerson(Person person) {
        log.info("Añadiendo persona {}", person);
        personRepository.save(person);
        return person;
    }

    @Override
    public Person findById(String id) {
        log.info("Buscando persona con id {}", id);
        return personRepository.findById(id) .orElseThrow();
    }

    @Override
    public void deleteById(String id) {
        log.info("Eliminando persona con id {}", id);
        findById(id);
        personRepository.deleteById(id);
    }

    @Override
    public Person updatePerson(String id, Person person) {
        log.info("Modificando persona con id {} y datos {}", id, person);
        findById(id);
        person.setId(id);
        personRepository.save(person);
        return person;
    }

    @Override
    public Page<Person> getPeople(int offset, int pageSize) {
        log.info("Mostrando todas las personas con offset {} y pageSize {}", offset, pageSize);
        return personRepository.findAll(PageRequest.of(offset, pageSize));
    }
}
