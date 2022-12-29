package com.bosonit.block7crudvalidation.infrastructure.controller;

import com.bosonit.block7crudvalidation.application.ProfService;
import com.bosonit.block7crudvalidation.domain.entity.Profesor;
import com.bosonit.block7crudvalidation.infrastructure.controller.dto.input.ProfInputDto;
import com.bosonit.block7crudvalidation.infrastructure.controller.dto.output.ProfOutputDto;
import com.bosonit.block7crudvalidation.infrastructure.mapper.ProfMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("profesores")
@AllArgsConstructor

public class ProfController {
    private ProfService profService;

    @GetMapping("/{id}")
    public ProfOutputDto getById(@PathVariable int id,
                                 @RequestParam(value = "outType", defaultValue = "simple") String outputType) {
        Profesor profesor = profService.getById(id);
        return (Objects.equals(outputType, "simple")) ? ProfMapper.INSTANCE.profesorToProfOutputDto(profesor) :
                (Objects.equals(outputType, "full")) ? ProfMapper.INSTANCE.profesorToProfFullOutputDto(profesor) :
                        new ProfOutputDto();
    }


    @GetMapping("/equipo_docente")
    public List<ProfOutputDto> getAll() {
        List<Profesor> profesors = profService.getAll();
        {
            return profesors.stream().map(ProfMapper.INSTANCE::profesorToProfOutputDto).toList();
        }
    }

    @PutMapping("/{id}")
    public void updateProf(@PathVariable int id,
                           @RequestBody ProfInputDto profInputDto) {
        Profesor profesor = ProfMapper.INSTANCE.profInputDtoToProfesor(profInputDto);
        profService.updateProf(id, profesor);

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        profService.deleteById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addProf(@RequestBody ProfInputDto profInputDto){
        Profesor profesor = ProfMapper.INSTANCE.profInputDtoToProfesor(profInputDto);
        profService.addProf(profesor, profInputDto.getPersonid());

    }

}
