package com.example.block10dockerizeapp.controller.dto;

import com.example.block10dockerizeapp.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonOutputDto {
    int id;
    String nombre;
    int edad;
    String poblacion;

    public PersonOutputDto(Person person) {
        id = person.getId();
        nombre = person.getNombre();
        edad = person.getEdad();
        poblacion = person.getPoblacion();
    }
}
