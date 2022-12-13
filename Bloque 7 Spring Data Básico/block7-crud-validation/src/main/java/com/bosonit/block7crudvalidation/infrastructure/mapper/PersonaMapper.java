package com.bosonit.block7crudvalidation.infrastructure.mapper;

import com.bosonit.block7crudvalidation.domain.entity.Persona;
import com.bosonit.block7crudvalidation.infrastructure.controller.dto.input.PersonaInputDto;
import com.bosonit.block7crudvalidation.infrastructure.controller.dto.output.PersonaOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonaMapper {
    PersonaMapper Instance = Mappers.getMapper(PersonaMapper.class);

    PersonaOutputDto personaToPersonaOutputDto(Persona persona);

    Persona personaInputDtoToPersona (PersonaInputDto personaInputDto);

}
