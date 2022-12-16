package com.bosonit.block7crudvalidation.domain.repository;

import com.bosonit.block7crudvalidation.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
