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
    public void addStudent(Student student,  int personId, int profId) {
        Person person = personService.getPersonById(personId);
        if(person.getStudent() != null || person.getProfesor() != null) {
            throw new UnprocessableEntityException("El ID introducido ya está asignado");
        }
        student.setPerson(person);
        person.setStudent(student);

        Profesor profesor = profService.getById(profId);
        student.setProfesor(profesor);
        List<Student> students = profesor.getStudents();
        students.add(student);
        profesor.setStudents(students);

        studentRepository.save(student);

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
//        this.getById(id);
//
//        student.setId(id);
//        studentRepository.save(student);
        Student studentDB = this.getById(id);
        studentDB.setComments(student.getComments());
        studentDB.setBranch(student.getBranch());
        studentRepository.save(studentDB);
    }

    @Override
    public void addSubjects(List<Subject> subjects) {
        subjects.forEach(subject -> {
            subjRepository.save(subject);
        });
    }
}
