package com.bosonit.JPACascade.mapper;

import com.bosonit.JPACascade.controller.dto.FacturaOutputDto;
import com.bosonit.JPACascade.controller.dto.LineaInputDto;
import com.bosonit.JPACascade.domain.entity.Factura;
import com.bosonit.JPACascade.domain.entity.Linea;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FacturaMapper {

    FacturaMapper INSTANCE = Mappers.getMapper(FacturaMapper.class);


    FacturaOutputDto facturaToFacturaOutputDto(Factura factura);


    Factura lineaToLineaOutput(Linea linea);


    Linea lineaInputDtoToLinea(LineaInputDto lineaInputDto);
}
