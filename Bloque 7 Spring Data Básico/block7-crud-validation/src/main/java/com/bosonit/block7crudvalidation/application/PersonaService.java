package com.bosonit.block7crudvalidation.application;

import com.bosonit.block7crudvalidation.infrastructure.controller.dto.input.PersonaInputDto;
import com.bosonit.block7crudvalidation.infrastructure.controller.dto.output.PersonaOutputDto;

import java.util.List;

public interface PersonaService {

    PersonaOutputDto getPersonaById(int id);
    PersonaOutputDto getPersonaByUsuario(String usuario);
    List<PersonaOutputDto> getPeople();

    PersonaOutputDto addPersona(PersonaInputDto persona);
    void deletePersonaById(int id);

    PersonaOutputDto updatePersona(PersonaInputDto persona, int id) throws Exception;
}
