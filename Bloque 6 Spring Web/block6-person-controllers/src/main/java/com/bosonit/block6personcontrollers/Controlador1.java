package com.bosonit.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/controlador1")
public class Controlador1 {

    @Autowired
    Servicio servicio;

    @GetMapping(value = "/addPersona")
    public Persona addPersona(@RequestHeader(value = "nombre") String nombre,
                              @RequestHeader(value = "edad") int edad,
                              @RequestHeader(value = "ciudad") String ciudad) {
        return servicio.crearPersona (nombre,edad,ciudad);
    }

    @PostMapping(value = "/addCiudad")
    public Ciudad addCiudad (@RequestBody Ciudad newCiudad) {
        servicio.addCiudad(newCiudad);
        return newCiudad;
    }


}
