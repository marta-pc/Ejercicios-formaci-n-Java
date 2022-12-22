package com.bosonit.block11cors.domain.repository;

import com.bosonit.block11cors.domain.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfRepository extends JpaRepository <Profesor, Integer> {

}
