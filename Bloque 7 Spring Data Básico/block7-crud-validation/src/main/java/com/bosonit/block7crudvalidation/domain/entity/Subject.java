package com.bosonit.block7crudvalidation.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "estudiante_asignatura")

public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignatura", nullable = false)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_student")
    private Student student;

    @Column(name = "asignatura")
    private String subject;

    private String comments;

    @Column (nullable = false)
    private Date initial_date;

    private Date finish_date;



}
