package com.bosonit.block6personcontrollers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Block6PersonControllersApplication {

	public static void main(String[] args) {
		SpringApplication.run(Block6PersonControllersApplication.class, args);
	}

	@Bean("bean1")
	Persona persona1(){
		Persona persona = new Persona();
		persona.setNombre("Nacho");
		persona.setEdad(28);
		persona.setCiudad("Cádiz");
		return persona;
	}

	@Bean("bean2")
	Persona persona2(){
		Persona persona = new Persona();
		persona.setNombre("Dante");
		persona.setEdad(29);
		persona.setCiudad("Murcia");
		return persona;
	}

	@Bean("bean3")
	Persona persona3(){
		Persona persona = new Persona();
		persona.setNombre("Rosario");
		persona.setEdad(30);
		persona.setCiudad("Sevilla");
		return persona;
	}
}
