package com.bosonit.block7crudvalidation.application;


import com.bosonit.block7crudvalidation.domain.entity.Person;
import com.bosonit.block7crudvalidation.domain.exception.EntityNotFoundException;
import com.bosonit.block7crudvalidation.domain.repository.PersonRepository;
import com.bosonit.block7crudvalidation.infrastructure.controller.dto.input.PersonInputDto;
import com.bosonit.block7crudvalidation.infrastructure.controller.dto.output.PersonOutputDto;
import com.bosonit.block7crudvalidation.infrastructure.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class PersonServiceImp implements PersonService{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public PersonOutputDto addPerson(PersonInputDto person){

        Person person1 = personRepository.save(PersonMapper.Instance.personInputDtoToPerson(person));
        return PersonMapper.Instance.personToPersonOutputDto(person1);
    }

    @Override
    public Person getPersonById(int id){
        return personRepository.findById(id) .orElseThrow(() -> new EntityNotFoundException("Id no encontrado"));
    }


    @Override
    public void deletePersonById(int id) {
        personRepository.findById(id).orElseThrow();
        personRepository.deleteById(id);
    }
    @Override
    public List<Person> getPeople() {
        return personRepository.findAll();
    }


    @Override
    public Person updatePerson(int id, Person person) {
        personRepository.findById(id).orElseThrow();
        person.setId(id);
        return personRepository.save(person);
    }

}


