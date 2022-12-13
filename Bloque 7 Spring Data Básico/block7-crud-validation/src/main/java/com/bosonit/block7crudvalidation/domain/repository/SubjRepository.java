package com.bosonit.block7crudvalidation.domain.repository;

import com.bosonit.block7crudvalidation.domain.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjRepository extends JpaRepository <Subject,Integer> {
}
