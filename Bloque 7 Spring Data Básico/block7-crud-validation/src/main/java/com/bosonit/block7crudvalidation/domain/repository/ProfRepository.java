package com.bosonit.block7crudvalidation.domain.repository;

import com.bosonit.block7crudvalidation.domain.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfRepository extends JpaRepository <Profesor, Integer> {

}
