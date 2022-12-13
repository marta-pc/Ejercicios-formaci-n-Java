package com.bosonit.block6personcontrollers;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioImp implements Servicio {

    public Persona persona = new Persona();

    public Persona crearPersona(String nombre, int edad, String ciudad){
        persona.setNombre(nombre);
        persona.setEdad(edad);
        persona.setCiudad(ciudad);
        return persona;
    }

    public Persona edad2(String nombre, int edad, String ciudad){
        persona.setNombre(nombre);
        persona.setEdad(edad*2);
        persona.setCiudad(ciudad);
        return persona;
    }

    public List<Ciudad> ciudades = new ArrayList<>();

    public void addCiudad(Ciudad info) {ciudades.add(info);}

    public List<Ciudad> listaCiudades(){
        return ciudades;
    }
}
