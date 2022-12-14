package com.bosonit.block7crudvalidation.domain.repository;

import com.bosonit.block7crudvalidation.domain.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjRepository extends JpaRepository <Subject,Integer> {
    List<Subject> getByStudentId(int id);
}
