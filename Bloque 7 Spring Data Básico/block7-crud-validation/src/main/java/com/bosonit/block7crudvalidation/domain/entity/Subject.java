package com.bosonit.block7crudvalidation.domain.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "estudiante_asignatura")

public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignatura")
    private int id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "id_student")
    private Student student;

    @Column(name = "asignatura")
    private String subject;

    private String comments;

    @Column (nullable = false)
    private Date initial_date = Date.from(Instant.now());

    private Date finish_date;



}
