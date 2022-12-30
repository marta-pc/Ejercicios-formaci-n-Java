package com.bosonit.block7crudvalidation.application;


import com.bosonit.block7crudvalidation.domain.entity.DateCondition;
import com.bosonit.block7crudvalidation.domain.entity.Person;
import com.bosonit.block7crudvalidation.domain.exception.EntityNotFoundException;
import com.bosonit.block7crudvalidation.domain.repository.PersonRepository;
import com.bosonit.block7crudvalidation.infrastructure.controller.dto.input.PersonInputDto;
import com.bosonit.block7crudvalidation.infrastructure.controller.dto.output.PersonOutputDto;
import com.bosonit.block7crudvalidation.infrastructure.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Service
public class PersonServiceImp implements PersonService{

    @Autowired
    private PersonRepository personRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PersonOutputDto addPerson(PersonInputDto person){

        Person person1 = personRepository.save(PersonMapper.Instance.personInputDtoToPerson(person));
        return PersonMapper.Instance.personToPersonOutputDto(person1);
    }

    @Override
    public Person getPersonById(int id){
        return personRepository.findById(id) .orElseThrow(() -> new EntityNotFoundException("Id no encontrado"));
    }


    @Override
    public void deletePersonById(int id) {
        personRepository.findById(id).orElseThrow();
        personRepository.deleteById(id);
    }
    @Override
    public List<Person> getPeople() {
        return personRepository.findAll();
    }


    @Override
    public Person updatePerson(int id, Person person) {
        personRepository.findById(id).orElseThrow();
        person.setId(id);
        return personRepository.save(person);
    }

    @Override
    public List<Person> getByFields(String usuario, String name, String surname, Date created_date, String orderBy, String dateCondition) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> query = criteriaBuilder.createQuery(Person.class);
        Root<Person> root = query.from(Person.class);

        List<Predicate> predicates = new ArrayList<>();
        if(usuario != null) {
            predicates.add(criteriaBuilder.like(root.get("user"), usuario));
        }

        if(name != null) {
            predicates.add(criteriaBuilder.like(root.get("name"), name));
        }

        if(surname != null) {
            predicates.add(criteriaBuilder.like(root.get("surname"), surname));
        }

        if(created_date != null) {

            switch (dateCondition){
                case DateCondition.EQUAL -> predicates.add(criteriaBuilder.equal(root.get("created_date"), created_date));
                case DateCondition.LESS_THAN -> predicates.add(criteriaBuilder.lessThan(root.get("created_date"), created_date));
                default -> predicates.add(criteriaBuilder.greaterThan(root.get("created_date"), created_date));
            }
        }



        query.select(root)
                .where(predicates.toArray(new Predicate[predicates.size()]));

        if(Objects.equals(orderBy, "usuario")) {
            query.orderBy(criteriaBuilder.asc(root.get("usuario")));
        }
        if(Objects.equals(orderBy, "name")) {
            query.orderBy(criteriaBuilder.asc(root.get("name")));
        }

        return entityManager.createQuery(query)
                .getResultList()
                .stream()
                .toList();


}

    @Override
    public Page<Person> getPeoplePagination(int offset, int pageSize) {
        return personRepository.findAll(PageRequest.of(offset, pageSize));    }

}


