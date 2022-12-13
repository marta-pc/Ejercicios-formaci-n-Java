package com.bosonit.block6personcontrollers;
import java.util.ArrayList;
import java.util.List;

public interface Servicio {

        Persona persona = new Persona();

        Persona crearPersona(String nombre,int edad, String ciudad);

        Persona edad2 (String nombre,int edad, String ciudad);

        List<Ciudad> ciudades = new ArrayList<>();

        void addCiudad(Ciudad info);

        List<Ciudad> listaCiudades();
    }

