package com.bosonit.block6pathvariableheaders;

public interface Servicio {

    //método para crear objeto que devuelve objeto
    public Planta addPlanta(Planta newPlanta);

    // método para hacer una llamada get y devolver una planta por id
    public Planta getPlantaById(int id);

    //método para hacer una llamada put y devolver una planta por id
    public Planta putPlantaById(int id);
}
