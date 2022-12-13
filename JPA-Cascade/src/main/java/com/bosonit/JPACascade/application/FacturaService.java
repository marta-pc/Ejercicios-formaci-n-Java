package com.bosonit.JPACascade.application;

import com.bosonit.JPACascade.domain.entity.Factura;
import com.bosonit.JPACascade.domain.entity.Linea;

import java.util.List;

public interface FacturaService {

    List<Factura> getFacturas();

    void deleteFacturaById(int id);

    Factura updateFacturaById(int id, Linea linea);

    Factura saveFactura (Factura factura, int id);
}
