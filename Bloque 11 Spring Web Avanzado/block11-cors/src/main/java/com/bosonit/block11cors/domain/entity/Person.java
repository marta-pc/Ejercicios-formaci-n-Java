package com.bosonit.block11cors.domain.entity;


import javax.persistence.*;
import lombok.Data;

import javax.persistence.Entity;
import java.time.Instant;
import java.util.Date;
@Entity
@Data

@Table(name="Persona")

public class Person {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private int id;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private boolean active;
    private Date created_date = Date.from(Instant.now());
    private String imagen_url;
    private Date termination_date;

    @OneToOne(cascade = CascadeType.ALL)
    private Student student;

    @OneToOne(cascade = CascadeType.ALL)
    private Profesor profesor;


}
