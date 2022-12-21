package com.example.block10dockerizeapp.repository;

import com.example.block10dockerizeapp.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    Optional<Person> findByNombre(String nombre);
}
