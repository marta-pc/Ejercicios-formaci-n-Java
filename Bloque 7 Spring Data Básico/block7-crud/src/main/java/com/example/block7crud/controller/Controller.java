package com.example.block7crud.controller;

import com.example.block7crud.application.PersonServiceImp;
import com.example.block7crud.controller.dto.PersonInputDto;
import com.example.block7crud.controller.dto.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class Controller {

    @Autowired
    PersonServiceImp personService;

    //Añadir Persona. Petición POST. Body:  { “name”:”Jesús” …. } http://URL/persona
    @PostMapping
    public ResponseEntity<PersonOutputDto> addPerson(@RequestBody PersonInputDto person) {
        URI location = URI.create("/person");
        return ResponseEntity.created(location).body(personService.addPerson(person));
    }

    //Modificar por id. Petición PUT. http://URL/persona/{id} - Body se manda los datos.
    //Tener en cuenta que si no se manda un campo este está a nulo y NO queremos modificar a NULO los campos.
    //En el caso de que el ID no exista devolver un 404 - Persona no encontrada.
    @PutMapping("/{id}")
    public ResponseEntity<PersonOutputDto> updatePerson(@RequestBody PersonInputDto person) {
        try {
            personService.getPersonById(person.getId());
            return  ResponseEntity.ok().body(personService.addPerson(person));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    //Borrar (por id). Petición DELETE. http://URL/persona/{id} - Devolver un objeto Persona o un 404: Persona no encontrada.
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersonById(@RequestParam int id) {
        try {
            personService.deletePersonById(id);
            return ResponseEntity.ok().body("Persona con id: "+id+" ha sido eliminada");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND + ": Persona no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    //Consultar:
    //Por Id Petición GET http://URL/persona/{id} Devolver Persona o un código HTTP 404 si no existe.
    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonById(@PathVariable int id) {
        try {
            return ResponseEntity.ok().body(personService.getPersonById(id));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND + ": Persona no encontrada", HttpStatus.NOT_FOUND);
        }
    }



    //Por nombre  http://URL/persona/nombre/{nombre}  Devolver List<Persona>
    @GetMapping("/nombre/{name}")
    public ResponseEntity<PersonOutputDto> getPersonByNombre(@PathVariable String nombre) {
        try {
            return ResponseEntity.ok().body(personService.getPersonByNombre(nombre));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //Devolver todos los registros  . http://URL/persona. Devolver List<Persona>
    @GetMapping("/persona")
    public List<PersonOutputDto> getPeople(){

        return personService.getPeople();

    }


}
