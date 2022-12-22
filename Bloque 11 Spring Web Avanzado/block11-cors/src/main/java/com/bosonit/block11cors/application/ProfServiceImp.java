package com.bosonit.block11cors.application;

import com.bosonit.block11cors.domain.entity.Person;
import com.bosonit.block11cors.domain.exception.UnprocessableEntityException;
import com.bosonit.block11cors.domain.exception.EntityNotFoundException;
import com.bosonit.block11cors.domain.entity.Profesor;
import com.bosonit.block11cors.domain.repository.ProfRepository;
import com.bosonit.block11cors.domain.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProfServiceImp implements ProfService{

    private ProfRepository profRepository;
    private PersonService personService;
    private StudentRepository studentRepository;


    @Override
    public Profesor getById(int id) {
        return profRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Id no encontrado"));
    }

    @Override
    public List<Profesor> getAll() {
        return profRepository.findAll();
    }

    @Override
    public void addProf(Profesor profesor) {
//        Person persona = personService.getPersonById();
//        if(profesor.getPerson()!=null || persona.getProfesor()!=null){
//            throw new UnprocessableEntityException("El ID introducido ya está asignado");
//        }
//        profesor.setPerson(profesor);
//        profesor.setProfesor(profesor);
        Person person = profesor.getPerson();
        person.setProfesor(profesor);
        profesor.setPerson(person);
        profRepository.save(profesor);
    }

    @Override
    public void deleteById(int id) {
        Profesor profesor = this.getById(id);
        profesor.getStudents().forEach(student ->{
            student.setProfesor(null);
            studentRepository.save(student);
        });
        profRepository.deleteById(id);

    }

    @Override
    public void updateProf(int id, Profesor profesor) {
        Profesor profesorDB = this.getById(id);
        profesorDB.setComments(profesor.getComments());
        profesorDB.setBranch(profesor.getBranch());
        profRepository.save(profesorDB);
    }
}
