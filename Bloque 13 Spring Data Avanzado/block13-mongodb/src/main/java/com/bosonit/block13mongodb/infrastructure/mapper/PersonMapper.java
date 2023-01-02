package com.bosonit.block13mongodb.infrastructure.mapper;

import com.bosonit.block13mongodb.domain.entity.Person;
import com.bosonit.block13mongodb.infrastructure.controller.dto.PersonOutputDto;
import com.bosonit.block13mongodb.infrastructure.controller.dto.PersonInputDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonOutputDto personToPersonOutputDto(Person person);
    Person personInputDtoToPerson(PersonInputDto person);

}
