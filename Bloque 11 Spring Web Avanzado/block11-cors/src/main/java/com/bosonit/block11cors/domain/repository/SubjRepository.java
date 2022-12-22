package com.bosonit.block11cors.domain.repository;

import com.bosonit.block11cors.domain.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjRepository extends JpaRepository <Subject,Integer> {
    List<Subject> getByStudentId(int id);
}
