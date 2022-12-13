package com.bosonit.JPACascade.domain.repository;

import com.bosonit.JPACascade.domain.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {

}
