package com.bosonit.block7crudvalidation.application;

import com.bosonit.block7crudvalidation.domain.entity.Person;
import com.bosonit.block7crudvalidation.domain.entity.Profesor;
import com.bosonit.block7crudvalidation.domain.entity.Student;
import com.bosonit.block7crudvalidation.domain.entity.Subject;
import com.bosonit.block7crudvalidation.domain.exception.EntityNotFoundException;
import com.bosonit.block7crudvalidation.domain.exception.UnprocessableEntityException;
import com.bosonit.block7crudvalidation.domain.repository.StudentRepository;
import com.bosonit.block7crudvalidation.domain.repository.SubjRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class StudentServiceImp implements StudentService{

    private StudentRepository studentRepository;
    private SubjRepository subjRepository;
    private PersonService personService;
    private ProfService profService;
    @Override
    public Student getById(int id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Id de estudiante no encontrado"));
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public void addStudent(Student student, int personaId, int profesorId) {
        Person persona = personService.getPersonById(personaId);
        if(persona.getStudent() != null || persona.getProfesor() != null) {
            throw new UnprocessableEntityException("El ID ya ha sido asignado");
        }
        student.setPersona(persona);
        persona.setStudent(student);
        student.setPersona(persona);

        Profesor profesor = profService.getById(profesorId);
        student.setProfesor(profesor);
        List<Student> students = profesor.getStudents();
        students.add(student);
        profesor.setStudents(students);

        studentRepository.save(student);
        profService.updateProf(profesorId, profesor);
    }

    @Override
    public void deleteById(int id) {
        this.getById(id);
        List<Subject> studies = subjRepository.getByStudentId(id);
        studies.forEach(subj -> subjRepository.deleteById(subj.getId()));
        studentRepository.deleteById(id);
    }

    @Override
    public void updateStudent(int id, Student student) {
        this.getById(id);

        student.setId(id);
        studentRepository.save(student);
    }

    @Override
    public void addSubjects(List<Subject> subjects) {
        subjects.forEach(subject -> {
            subjRepository.save(subject);
        });
    }
}
