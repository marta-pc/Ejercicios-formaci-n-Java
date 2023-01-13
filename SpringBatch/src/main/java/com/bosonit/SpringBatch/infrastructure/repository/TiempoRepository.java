package com.bosonit.SpringBatch.infrastructure.repository;

import com.bosonit.SpringBatch.models.Tiempo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TiempoRepository extends JpaRepository<Tiempo, Integer> {
}
