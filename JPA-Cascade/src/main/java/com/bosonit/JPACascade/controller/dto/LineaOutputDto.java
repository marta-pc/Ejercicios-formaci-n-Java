package com.bosonit.JPACascade.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LineaOutputDto {

    int idFra;

    String producto;

    double cantidad;

    double importe;


}
