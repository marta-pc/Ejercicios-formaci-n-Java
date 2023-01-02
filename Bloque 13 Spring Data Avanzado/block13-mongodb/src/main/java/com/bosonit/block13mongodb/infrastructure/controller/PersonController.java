package com.bosonit.block13mongodb.infrastructure.controller;

import com.bosonit.block13mongodb.application.PersonService;
import com.bosonit.block13mongodb.domain.entity.Person;
import com.bosonit.block13mongodb.infrastructure.controller.dto.PersonInputDto;
import com.bosonit.block13mongodb.infrastructure.controller.dto.PersonOutputDto;
import com.bosonit.block13mongodb.infrastructure.mapper.PersonMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("person")
@AllArgsConstructor
public class PersonController {

    private PersonService personService;

    @PostMapping
    PersonInputDto addPerson(@RequestBody PersonInputDto personInputDto){
        Person person = PersonMapper.INSTANCE.personInputDtoToPerson(personInputDto);
        personService.addPerson(person);
        return personInputDto;
    }

    @GetMapping("{id}")
    PersonOutputDto findById(@PathVariable String id) {
        Person person = personService.findById(id);
        return PersonMapper.INSTANCE.personToPersonOutputDto(person);
    }

    @DeleteMapping("{id}")
    void deleteById(@PathVariable String id) {
        personService.deleteById(id);
    }

    @PutMapping("{id}")
    void updatePerson(@PathVariable String id, @RequestBody PersonInputDto personInputDto) {
        Person person = PersonMapper.INSTANCE.personInputDtoToPerson(personInputDto);
        personService.updatePerson(id, person);
    }

    @GetMapping("people")
    Page<PersonOutputDto> getPeople(@RequestParam(name = "offset") int offset,
                                  @RequestParam(name = "pageSize") int pageSize) {
        return personService.getPeople(offset, pageSize).map(PersonMapper.INSTANCE::personToPersonOutputDto);
    }
}
