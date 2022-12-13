package Persona.controller;

import Persona.controller.dto.PersonaInputDto;
import Persona.controller.dto.PersonaOutputDto;
import Persona.application.PersonaService;
import Persona.exception.EntityNotFoundException;
import Persona.exception.UnprocessableEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/{id}")
    public ResponseEntity<PersonaOutputDto> getPersonById(@PathVariable int id) {
        try {
            return ResponseEntity.ok().body(personaService.getPersonaById(id));
        } catch (Exception e) {
            throw new EntityNotFoundException("ID no encontrado");
        }
    }

    @GetMapping("/usuario/{usuario}")
    public ResponseEntity<PersonaOutputDto> getPersonByUsuario(@PathVariable String usuario) {
        try {
            return ResponseEntity.ok().body(personaService.getPersonaByUsuario(usuario));
        } catch (Exception e) {
            throw new EntityNotFoundException("Usuario no encontrado");
        }
    }

    @GetMapping("/registros")
    public List<PersonaOutputDto> getPeople(){
        return personaService.getPeople();
    }


    @PostMapping(value="/adduser")
    public ResponseEntity<PersonaOutputDto> addPersona(@RequestBody PersonaInputDto persona)  {
        try{
        System.out.println(persona.toString());
            return ResponseEntity.ok().body(personaService.addPersona(persona));
        }catch (Exception e) {
           throw new UnprocessableEntityException("No se ha podido procesar la información");
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersonaById(@PathVariable int id) {
        try {
            personaService.deletePersonaById(id);
            return ResponseEntity.ok().body("Persona con id: "+id+" ha sido eliminada");
        } catch (Exception e) {
            throw new EntityNotFoundException("Usuario no encontrado");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaOutputDto> updatePersona(@RequestBody PersonaInputDto persona,
                                                         @PathVariable int id) {
        try {
            return ResponseEntity.ok().body(personaService.updatePersona(persona, id));
        } catch (Exception e) {
            throw new EntityNotFoundException("Usuario no encontrado");
        }
    }
}
