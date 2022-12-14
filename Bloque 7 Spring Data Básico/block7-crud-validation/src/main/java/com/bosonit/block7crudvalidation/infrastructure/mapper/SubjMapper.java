package com.bosonit.block7crudvalidation.infrastructure.mapper;

import com.bosonit.block7crudvalidation.domain.entity.Subject;
import com.bosonit.block7crudvalidation.infrastructure.controller.dto.input.SubjInputDto;
import com.bosonit.block7crudvalidation.infrastructure.controller.dto.output.SubjOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjMapper {

    SubjMapper INSTANCE = Mappers.getMapper(SubjMapper.class);
    Subject subjInputDtoToSubject(SubjInputDto subjInputDto);
    SubjOutputDto subjectToSubjOutputDto(Subject student);


}
