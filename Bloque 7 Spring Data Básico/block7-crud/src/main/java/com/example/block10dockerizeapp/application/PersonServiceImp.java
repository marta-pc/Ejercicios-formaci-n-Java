package com.example.block10dockerizeapp.application;

import com.example.block10dockerizeapp.controller.dto.PersonInputDto;
import com.example.block10dockerizeapp.controller.dto.PersonOutputDto;
import com.example.block10dockerizeapp.domain.Person;
import com.example.block10dockerizeapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PersonServiceImp implements PersonService{
    @Autowired
    PersonRepository personRepository;

    @Override
    public PersonOutputDto addPerson (PersonInputDto person){
        return personRepository.save(new Person(person))
                .personToPersonOutputDto();
    }

    @Override
    public PersonOutputDto getPersonById(int id){
        return personRepository.findById(id).orElseThrow()
                .personToPersonOutputDto();
    }

    @Override
    public PersonOutputDto getPersonByNombre(String nombre){
        return personRepository.findByNombre(nombre).orElseThrow()
                .personToPersonOutputDto();
    }

    @Override
    public void deletePersonById(int id) {
        personRepository.findById(id).orElseThrow();
        personRepository.deleteById(id);
    }
    @Override
    public List<PersonOutputDto> getPeople() {
        return personRepository.findAll()
                .stream()
                .map(PersonOutputDto::new).collect(Collectors.toList());
    }


    @Override
    public PersonOutputDto updatePerson(PersonInputDto person) {
        personRepository.findById(person.getId()).orElseThrow();
        return personRepository.save(new Person(person))
                .personToPersonOutputDto();
    }

}


