package com.bosonit.block6pathvariableheaders;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioImp implements Servicio{

    List<Planta> listaPlanta = new ArrayList<>();

    @Override
    public Planta addPlanta(Planta newPlanta) {
        listaPlanta.add (newPlanta);
        return newPlanta;
    };

    @Override
    public Planta getPlantaById(int id) {
        Optional<Planta> planta = listaPlanta.stream().filter(p -> id == p.getId()).findFirst();

        return planta.get();
    }

    @Override
    public Planta putPlantaById(int id) {
        Optional<Planta> planta = listaPlanta.stream().filter(p -> id == p.getId()).findFirst();

        return planta.get();
    }
}
