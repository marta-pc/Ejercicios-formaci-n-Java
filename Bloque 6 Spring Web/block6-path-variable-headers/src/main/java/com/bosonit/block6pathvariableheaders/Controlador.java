package com.bosonit.block6pathvariableheaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class Controlador {

    @Autowired
    ServicioImp servicioImp;

    @PostMapping("/user")
    public Planta addPlanta(@RequestBody Planta bodyPlanta){
        return servicioImp.addPlanta(bodyPlanta);
    }
     @GetMapping("/user/{id}")
    public Planta getPlantaById(@PathVariable int id){
        return servicioImp.getPlantaById(id);
     }


    @PutMapping("/post")
    public HashMap<String,String> getValues(@RequestParam String var1, @RequestParam String var2){
        HashMap<String,String> hashMap= new HashMap<>();
        hashMap.put("var1", var1);
        hashMap.put("var2", var2);
        return hashMap;
        }

}
