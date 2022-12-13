package com.example.block7crud.controller.dto;

import com.example.block7crud.domain.Person;
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
