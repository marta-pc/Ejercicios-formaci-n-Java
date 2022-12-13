package com.bosonit.block6simplecontrollers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/user")
public class Saludo {

    @GetMapping(value = "/{nombre}" )
    public String hola (@PathVariable String nombre) {
        return "Hola " + nombre;
    }

    @PostMapping(value = "/useradd" )
    public Persona AddPersona (@RequestBody Persona persona) {
        persona.setEdad(persona.getEdad()+ 1);
        return persona;

    }

}
