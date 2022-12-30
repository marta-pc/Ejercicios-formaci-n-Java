package com.bosonit.block7crudvalidation.domain.repository;

import com.bosonit.block7crudvalidation.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByUsuario(String usuario);
    List<Person> findByName(String name);


}
