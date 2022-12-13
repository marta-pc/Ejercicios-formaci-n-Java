package com.bosonit.block7crudvalidation.controller.dto;

import com.bosonit.block7crudvalidation.domain.entity.Persona;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-05T11:42:48+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
public class PersonaMapperImpl implements PersonaMapper {

    @Override
    public PersonaOutputDto personaToPersonaOutputDto(Persona persona) {
        if ( persona == null ) {
            return null;
        }

        PersonaOutputDto personaOutputDto = new PersonaOutputDto();

        personaOutputDto.setId( persona.getId() );
        personaOutputDto.setUsuario( persona.getUsuario() );
        personaOutputDto.setPassword( persona.getPassword() );
        personaOutputDto.setName( persona.getName() );
        personaOutputDto.setSurname( persona.getSurname() );
        personaOutputDto.setCompany_email( persona.getCompany_email() );
        personaOutputDto.setPersonal_email( persona.getPersonal_email() );
        personaOutputDto.setCity( persona.getCity() );
        personaOutputDto.setActive( persona.isActive() );
        personaOutputDto.setCreated_date( persona.getCreated_date() );
        personaOutputDto.setImagen_url( persona.getImagen_url() );
        personaOutputDto.setTermination_date( persona.getTermination_date() );

        return personaOutputDto;
    }

    @Override
    public Persona personaInputDtoToPersona(PersonaInputDto personaInputDto) {
        if ( personaInputDto == null ) {
            return null;
        }

        Persona persona = new Persona();

        persona.setUsuario( personaInputDto.getUsuario() );
        persona.setPassword( personaInputDto.getPassword() );
        persona.setName( personaInputDto.getName() );
        persona.setSurname( personaInputDto.getSurname() );
        persona.setCompany_email( personaInputDto.getCompany_email() );
        persona.setPersonal_email( personaInputDto.getPersonal_email() );
        persona.setCity( personaInputDto.getCity() );
        if ( personaInputDto.getActive() != null ) {
            persona.setActive( personaInputDto.getActive() );
        }
        persona.setImagen_url( personaInputDto.getImagen_url() );

        return persona;
    }
}
