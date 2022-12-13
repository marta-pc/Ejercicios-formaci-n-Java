package com.bosonit.JPACascade.domain.repository;

import com.bosonit.JPACascade.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


}
