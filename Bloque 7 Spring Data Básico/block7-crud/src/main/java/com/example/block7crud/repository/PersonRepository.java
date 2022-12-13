package com.example.block7crud.repository;

import com.example.block7crud.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    Optional<Person> findByNombre(String nombre);
}
