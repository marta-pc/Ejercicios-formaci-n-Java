package com.bosonit.block11cors.infrastructure.mapper;

import com.bosonit.block11cors.domain.entity.Subject;
import com.bosonit.block11cors.infrastructure.controller.dto.input.SubjInputDto;
import com.bosonit.block11cors.infrastructure.controller.dto.output.SubjOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjMapper {

    SubjMapper INSTANCE = Mappers.getMapper(SubjMapper.class);
    Subject subjInputDtoToSubject(SubjInputDto subjInputDto);
    SubjOutputDto subjectToSubjOutputDto(Subject student);


}
