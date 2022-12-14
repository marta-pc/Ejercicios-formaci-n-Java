package com.bosonit.block7crudvalidation.infrastructure.mapper;

import com.bosonit.block7crudvalidation.domain.entity.Profesor;
import com.bosonit.block7crudvalidation.infrastructure.controller.dto.input.ProfInputDto;
import com.bosonit.block7crudvalidation.infrastructure.controller.dto.output.ProfFullOutputDto;
import com.bosonit.block7crudvalidation.infrastructure.controller.dto.output.ProfOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfMapper {

    ProfMapper INSTANCE = Mappers.getMapper(ProfMapper.class);

    Profesor profInputDtoToProfesor(ProfInputDto profInputDto);

    ProfOutputDto profesorToProfOutputDto(Profesor profesor);

    ProfFullOutputDto profesorToProfFullOutputDto(Profesor profesor);
}
