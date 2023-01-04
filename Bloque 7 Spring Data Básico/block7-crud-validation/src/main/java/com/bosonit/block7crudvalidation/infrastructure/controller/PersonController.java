package com.bosonit.block7crudvalidation.infrastructure.controller;


import com.bosonit.block7crudvalidation.application.PersonServiceImp;
import com.bosonit.block7crudvalidation.domain.entity.DateCondition;
import com.bosonit.block7crudvalidation.domain.entity.Person;
import com.bosonit.block7crudvalidation.infrastructure.controller.dto.input.PersonInputDto;
import com.bosonit.block7crudvalidation.infrastructure.controller.dto.output.PersonOutputDto;
import com.bosonit.block7crudvalidation.infrastructure.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonController {

    @Autowired
    PersonServiceImp personService;

    @PostMapping
    public ResponseEntity<PersonOutputDto> addPerson(@RequestBody PersonInputDto person) {
        URI location = URI.create("/person");
        Person person1 = PersonMapper.Instance.personInputDtoToPerson(person);
        PersonOutputDto person2 = PersonMapper.Instance.personToPersonOutputDto(personService.addPerson(person1));
        return ResponseEntity.created(location).body(person2);
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



    @GetMapping("/personas")
    public List<PersonOutputDto> getPeople(){

        return personService.getPeople().stream().map(person -> PersonMapper.Instance.personToPersonOutputDto(person)).toList();

    }


    @GetMapping("/fields")
    public List<Person> searchByFields(@RequestParam(name = "usuario", required = false) String usuario,
                                                @RequestParam(name = "name", required = false) String name,
                                                @RequestParam(name = "surname", required = false) String surname,
                                                @RequestParam(name = "created_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date created_date,
                                                @RequestParam(required=false, defaultValue = DateCondition.GREATER_THAN) String dateCondition,
                                                @RequestParam(name = "orderBy", defaultValue = "usuario", required = false) String orderBy) {

        List<Person> people = personService.getByFields(usuario, name, surname, created_date, orderBy, dateCondition);
        return people.stream().toList();

    }


    @GetMapping("/paginated")
    public Page<PersonOutputDto> searchAllWithPagination(@RequestParam(value = "offset") int offset,
                                                @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Page<Person> people = personService.getPeoplePagination(offset, pageSize);

        return people.map(PersonMapper.Instance::personToPersonOutputDto);
    }

}
