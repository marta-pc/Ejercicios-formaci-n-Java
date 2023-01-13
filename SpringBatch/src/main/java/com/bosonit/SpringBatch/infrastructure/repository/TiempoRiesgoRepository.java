package com.bosonit.SpringBatch.infrastructure.repository;

import com.bosonit.SpringBatch.models.TiempoRiesgo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiempoRiesgoRepository extends JpaRepository<TiempoRiesgo, Integer> {

}
