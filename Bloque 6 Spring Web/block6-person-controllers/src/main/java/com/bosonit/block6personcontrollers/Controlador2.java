package com.bosonit.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class Controlador2 {

    @Autowired
    Servicio servicio;

    @GetMapping("/controlador2/getPersona")
    public Persona doblar (@RequestHeader(value="nombre")String nombre,
                           @RequestHeader(value="edad")int edad,
                           @RequestHeader(value="ciudad")String ciudad){
        return servicio.edad2(nombre,edad,ciudad);
    }

    @GetMapping("/controlador1/getCiudad")
    public List<Ciudad> mostrar () {
        return servicio.listaCiudades();
    }
}
