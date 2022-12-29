package com.bosonit.block7crudvalidation.domain.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name= "estudiantes")

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private int id;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona")
    private Person person;

    @Column(name = "num_hours_week")
    private int hours;

    private String comments;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    @Column (nullable = false)
    private String branch;

    @OneToMany(mappedBy = "student")
    private List<Subject> studies = new ArrayList<>();



}
