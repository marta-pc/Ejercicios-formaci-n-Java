package Persona.controller.dto;

import Persona.domain.Persona;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonaMapper {
    PersonaMapper Instance = Mappers.getMapper(PersonaMapper.class);

    PersonaOutputDto personaToPersonaOutputDto(Persona persona);

    Persona personaInputDtoToPersona (PersonaInputDto personaInputDto);

}
