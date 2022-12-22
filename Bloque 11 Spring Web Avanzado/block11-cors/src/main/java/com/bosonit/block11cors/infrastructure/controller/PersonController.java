package com.bosonit.block11cors.infrastructure.controller;


import com.bosonit.block11cors.application.PersonServiceImp;
import com.bosonit.block11cors.domain.entity.Person;
import com.bosonit.block11cors.infrastructure.controller.dto.input.PersonInputDto;
import com.bosonit.block11cors.infrastructure.controller.dto.output.PersonOutputDto;
import com.bosonit.block11cors.infrastructure.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController

public class PersonController {

    @Autowired
    PersonServiceImp personService;

    @PostMapping("/addperson")
    public ResponseEntity<PersonOutputDto> addPerson(@RequestBody PersonInputDto person) {
        URI location = URI.create("/person");
        return ResponseEntity.created(location).body(personService.addPerson(person));
    }


    @PutMapping("/{id}")
    public ResponseEntity<PersonOutputDto> updatePerson(@PathVariable int id, @RequestBody PersonInputDto person) {
            Person person1 = PersonMapper.Instance.personInputDtoToPerson(person);
            PersonOutputDto person2 = PersonMapper.Instance.personToPersonOutputDto(personService.updatePerson(id, person1));
            return  ResponseEntity.ok().body(person2);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersonById(@PathVariable int id) {
        try {
            personService.deletePersonById(id);
            return ResponseEntity.ok().body("Persona con id: "+id+" ha sido eliminada");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND + ": Persona no encontrada", HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonById(@PathVariable int id) {
        try {
            return ResponseEntity.ok().body(personService.getPersonById(id));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND + ": Persona no encontrada", HttpStatus.NOT_FOUND);
        }
    }




    @GetMapping("/getall")
    public List<PersonOutputDto> getPeople(){

        return personService.getPeople().stream().map(person -> PersonMapper.Instance.personToPersonOutputDto(person)).toList();

    }


}
