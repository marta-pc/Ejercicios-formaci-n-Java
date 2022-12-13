package com.bosonit.JPACascade.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "CabeceraFra")

public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cli_codi")
    private Cliente cliente;

    private double importe;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<Linea> lineasFra = new ArrayList<>();



}
