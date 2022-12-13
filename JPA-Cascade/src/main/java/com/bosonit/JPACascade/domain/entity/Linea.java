package com.bosonit.JPACascade.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name= "LineasFra")

public class Linea {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "idFra")
    private int id;

    @Column(name = "proNomb", nullable = false)
    private String producto;

    private double cantidad;

    @Column(name = "precio")
    private double importe;

    @ManyToOne
    @JoinColumn(name = "factura")
    private Factura factura;




    }
