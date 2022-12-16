package com.bosonit.block7crudvalidation.infrastructure.mapper;

import com.bosonit.block7crudvalidation.domain.entity.Person;
import com.bosonit.block7crudvalidation.infrastructure.controller.dto.input.PersonInputDto;
import com.bosonit.block7crudvalidation.infrastructure.controller.dto.output.PersonOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper Instance = Mappers.getMapper(PersonMapper.class);

    PersonOutputDto personToPersonOutputDto(Person persona);

    Person personInputDtoToPerson (PersonInputDto personInputDto);

    PersonOutputDto personInputDtoToPersonOutDto (PersonInputDto personInputDto);


}
