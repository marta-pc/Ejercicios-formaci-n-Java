package com.bosonit.block7crudvalidation.application;

import com.bosonit.block7crudvalidation.infrastructure.controller.dto.input.PersonaInputDto;
import com.bosonit.block7crudvalidation.infrastructure.mapper.PersonaMapper;
import com.bosonit.block7crudvalidation.infrastructure.controller.dto.output.PersonaOutputDto;
import com.bosonit.block7crudvalidation.domain.entity.Persona;
import com.bosonit.block7crudvalidation.domain.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonaServiceImp implements PersonaService{

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDto getPersonaById(int id){
        Persona persona = personaRepository.findById(id).orElseThrow();
        PersonaOutputDto personaDb = PersonaMapper.Instance.personaToPersonaOutputDto(persona);
        return personaDb;
    }

    @Override
    public PersonaOutputDto getPersonaByUsuario(String usuario) {
        Persona persona = personaRepository.findByUsuario(usuario).orElseThrow();
        PersonaOutputDto personaDb = PersonaMapper.Instance.personaToPersonaOutputDto(persona);
        return personaDb;
    }

    @Override
    public List<PersonaOutputDto> getPeople() {
        return personaRepository.findAll()
                .stream()
                .map(persona -> PersonaMapper.Instance.personaToPersonaOutputDto(persona)).toList();

    }

    @Override
    public PersonaOutputDto addPersona(PersonaInputDto persona) {
        Persona persona1 = PersonaMapper.Instance.personaInputDtoToPersona(persona);
        Persona personaDb = personaRepository.save(persona1);
        PersonaOutputDto persona2 = PersonaMapper.Instance.personaToPersonaOutputDto(personaDb);
        return persona2;
    }

    @Override
    public void deletePersonaById(int id) {
        personaRepository.findById(id).orElseThrow();
        personaRepository.deleteById(id);
    }

    @Override
    public PersonaOutputDto updatePersona(PersonaInputDto persona, int id) throws Exception {
        Optional<Persona> personaDb = personaRepository.findById(id);
        Persona personaInput = PersonaMapper.Instance.personaInputDtoToPersona(persona);

        Boolean isEqual = Objects.equals(personaDb, personaInput);
        if(isEqual){
            throw new Exception();
        }
        personaRepository.save(personaInput);
        return PersonaMapper.Instance.personaToPersonaOutputDto(personaInput);
    }
}
