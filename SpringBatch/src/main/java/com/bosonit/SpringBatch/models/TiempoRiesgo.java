package com.bosonit.SpringBatch.models;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class TiempoRiesgo {

    public static final String HIGH = "Alto";
    public static final String LOW = "Medio";
    public static final String NORMAL = "Bajo";


    @Id
    @GeneratedValue
    private int id;
    private String localidad;
    private String fecha;
    private int temperatura;
    private String anio;
    private String mes;
    private String dia;
//    private int numeroMediciones;
//    private Float temperaturaMedia;
    private String riesgo;

    @OneToOne(cascade = CascadeType.ALL)
    Tiempo tiempo;

    public TiempoRiesgo(String localidad, String fecha, int temperatura, String anio, String mes, String dia, String riesgo, Tiempo tiempo) {
        this.localidad = localidad;
        this.fecha = fecha;
        this.temperatura = temperatura;
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
        this.riesgo = riesgo;
        this.tiempo = tiempo;
    }

}
