package com.bosonit.JPACascade.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class FacturaOutputDto {

    int id;
    double importe;

    ClienteOutputDto cliente;
    List<LineaOutputDto> lineas;

}
