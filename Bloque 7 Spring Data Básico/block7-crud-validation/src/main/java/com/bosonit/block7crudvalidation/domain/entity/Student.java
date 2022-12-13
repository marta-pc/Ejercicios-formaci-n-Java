package com.bosonit.block7crudvalidation.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name= "estudiante_asignatura")

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student", nullable = false)
    private int idstudent;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @Column(name = "num_hours_week")
    private int hours;

    private String comments;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    @Column (nullable = false)
    private String branch;

    @OneToMany(mappedBy = "student")
    private List<Subject> studies = new ArrayList<>();


}
