package Persona.application;

import Persona.controller.dto.PersonaInputDto;
import Persona.controller.dto.PersonaOutputDto;

import java.util.List;

public interface PersonaService {

    PersonaOutputDto getPersonaById(int id);
    PersonaOutputDto getPersonaByUsuario(String usuario);
    List<PersonaOutputDto> getPeople();

    PersonaOutputDto addPersona(PersonaInputDto persona);
    void deletePersonaById(int id);

    PersonaOutputDto updatePersona(PersonaInputDto persona, int id) throws Exception;
}
