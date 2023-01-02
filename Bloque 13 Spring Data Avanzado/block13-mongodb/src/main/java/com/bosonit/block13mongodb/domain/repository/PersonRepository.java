package com.bosonit.block13mongodb.domain.repository;

import com.bosonit.block13mongodb.domain.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
}
