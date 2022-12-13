package com.example.block7crud.domain;

import com.example.block7crud.controller.dto.PersonInputDto;
import com.example.block7crud.controller.dto.PersonOutputDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Person {

    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    private int edad;
    private String poblacion;

    public Person (PersonInputDto personInputDto) {
        this.id = personInputDto.getId();
        this.nombre = personInputDto.getNombre();
        this.edad = personInputDto.getEdad();
        this.poblacion = personInputDto.getPoblacion();
    }

    public PersonOutputDto personToPersonOutputDto() {
        return new PersonOutputDto(
                this.id,
                this.nombre,
                this.edad,
                this.poblacion
        );
    }


}


