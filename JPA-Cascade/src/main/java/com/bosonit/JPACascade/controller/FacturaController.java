package com.bosonit.JPACascade.controller;

import com.bosonit.JPACascade.application.FacturaService;
import com.bosonit.JPACascade.controller.dto.FacturaOutputDto;
import com.bosonit.JPACascade.controller.dto.LineaInputDto;
import com.bosonit.JPACascade.domain.entity.Linea;
import com.bosonit.JPACascade.mapper.FacturaMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

public class FacturaController {

    private FacturaService facturaService;

    @GetMapping("/factura")
    public List<FacturaOutputDto> getFacturas(){

            return facturaService.getFacturas().stream().map(FacturaMapper.INSTANCE::facturaToFacturaOutputDto).toList();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFacturaById(@PathVariable int id) {
        try {
            facturaService.deleteFacturaById(id);
            return ResponseEntity.ok().body("Factura con id: " + id + "ha sido eliminada");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND + ": Factura no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<FacturaOutputDto> updateFacturaById(@PathVariable int id, @RequestBody LineaInputDto lineaInputDto){
        try {
            Linea linea = FacturaMapper.INSTANCE.lineaInputDtoToLinea(lineaInputDto);
            return ResponseEntity.ok().body (FacturaMapper.INSTANCE.facturaToFacturaOutputDto(facturaService.updateFacturaById(id, linea)));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
