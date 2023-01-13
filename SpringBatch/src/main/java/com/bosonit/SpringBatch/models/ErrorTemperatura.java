package com.bosonit.SpringBatch.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorTemperatura {
    private String localidad;
    private String fecha;
    private int temperatura;
}
