package com.bosonit.JPACascade.application;

import com.bosonit.JPACascade.controller.dto.LineaInputDto;
import com.bosonit.JPACascade.domain.entity.Cliente;
import com.bosonit.JPACascade.domain.entity.Factura;
import com.bosonit.JPACascade.domain.entity.Linea;
import com.bosonit.JPACascade.domain.repository.ClienteRepository;
import com.bosonit.JPACascade.domain.repository.FacturaRepository;
import com.bosonit.JPACascade.mapper.FacturaMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j

public class FacturaServiceImp implements FacturaService{

    private FacturaRepository facturaRepository;
    private ClienteService clienteService;


    @Override
    public List<Factura> getFacturas() {
        return facturaRepository.findAll();
    }

    @Override
    public void deleteFacturaById(int id) {
        findByID(id);
        facturaRepository.deleteById(id);
    }

    private Factura findByID(int id) {
        return facturaRepository.findById(id).orElseThrow();
    }

    @Override
    public Factura updateFacturaById(int id, Linea linea) {
        Factura factura = findByID(id);
        linea.setFactura(factura);
        List<Linea> lineas = factura.getLineasFra();
        lineas.add(linea);
        factura.setLineasFra(lineas);

        factura.setImporte(factura.getImporte());

        return facturaRepository.save(factura);
    }


    @Override
    public Factura saveFactura(Factura factura, int id) {
        Cliente cliente = clienteService.findById(id);
        factura.setCliente(cliente);
        factura.setImporte(factura.getImporte());
        return facturaRepository.save(factura);

    }
}
