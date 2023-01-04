package com.bosonit.block7crudvalidation.application;

import com.bosonit.block7crudvalidation.domain.entity.Person;
import com.bosonit.block7crudvalidation.domain.exception.EntityNotFoundException;
import com.bosonit.block7crudvalidation.domain.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceImpTest {

    @InjectMocks
    private PersonServiceImp personService;

    @Mock
    private PersonRepository personRepository;

    @Test
    void addPerson() {
        // GIVEN
        Person expectedPerson = new Person ();
        expectedPerson.setName("Marta");
        expectedPerson.setPassword("1234");

        given(personRepository.save(expectedPerson)).willReturn(expectedPerson);

        // WHEN
        Person actualPerson =
                assertDoesNotThrow(() -> personService.addPerson(expectedPerson));

        // THEN
        assertEquals(expectedPerson, actualPerson);
        verify(personRepository, times(1)).save(expectedPerson);
    }

    @Test
    void getPersonByIdExists() {
        // GIVEN
        Person expectedPerson = new Person ();
        expectedPerson.setId(1);
        expectedPerson.setName("Marta");
        expectedPerson.setPassword("1234");

        given(personRepository.findById(expectedPerson.getId())).willReturn(Optional.of(expectedPerson));

        // WHEN
        Person actualPerson =
                assertDoesNotThrow(() -> personService.getPersonById(expectedPerson.getId()));

        // THEN
        assertEquals(expectedPerson, actualPerson);
        verify(personRepository, times(1)).findById(expectedPerson.getId());
    }

    @Test
    void getPersonByIdNotExists() {
        // GIVEN
        int id = 1;
        EntityNotFoundException expectedException = new EntityNotFoundException("Id no encontrado");
        given(personRepository.findById(id)).willReturn(Optional.empty());

        // WHEN
        EntityNotFoundException actualException =
                assertThrows(EntityNotFoundException.class, () -> personService.getPersonById(id));

        // THEN
        assertEquals(expectedException.getMessage(), actualException.getMessage());
        verify(personRepository, times(1)).findById(id);
    }

    @Test
    void deletePersonById() {
        // GIVEN
        int id = 1;
        Person expectedPerson = new Person();
        expectedPerson.setId(1);
        expectedPerson.setName("Marta");
        expectedPerson.setPassword("1234");

        given(personRepository.findById(id)).willReturn(Optional.of(expectedPerson));
        doNothing().when(personRepository).deleteById(id);

        // WHEN
        assertDoesNotThrow(() -> personService.deletePersonById(id));

        // THEN
        verify(personRepository, times(1)).findById(id);
        verify(personRepository, times(1)).deleteById(id);
    }

    @Test
    void getPeople() {
        // GIVEN
        Person expectedPerson = new Person();
        expectedPerson.setId(1);
        expectedPerson.setName("Marta");
        expectedPerson.setPassword("1234");

        Person expectedPerson2 = new Person();
        expectedPerson2.setId(2);
        expectedPerson2.setName("Laura");
        expectedPerson2.setPassword("1234");

        given(personRepository.findAll()).willReturn(List.of(expectedPerson, expectedPerson2));

        // WHEN
        List<Person> actualPeople = assertDoesNotThrow(() -> personService.getPeople());

        // THEN
        assertEquals(List.of(expectedPerson, expectedPerson2), actualPeople);
        verify(personRepository, times(1)).findAll();
    }

    @Test
    void updatePerson() {
        // GIVEN
        int id = 1;
        Person expectedPerson = new Person();
        expectedPerson.setId(1);
        expectedPerson.setName("Marta");
        expectedPerson.setPassword("1234");

        given(personRepository.findById(id)).willReturn(Optional.of(expectedPerson));
        given(personRepository.save(expectedPerson)).willReturn(expectedPerson);

        // WHEN
        Person actualPerson =
            assertDoesNotThrow(() -> personService.updatePerson(id, expectedPerson));

        // THEN
        assertEquals(expectedPerson, actualPerson);
        verify(personRepository, times(1)).findById(expectedPerson.getId());
        verify(personRepository, times(1)).save(expectedPerson);
    }

    @Test
    void getPeoplePagination(){
        // GIVEN
        int offset = 0;
        int pageSize = 10;
        Person expectedPerson = new Person();
        expectedPerson.setId(1);
        expectedPerson.setName("Marta");
        expectedPerson.setPassword("1234");

        Person expectedPerson2 = new Person();
        expectedPerson2.setId(2);
        expectedPerson2.setName("Laura");
        expectedPerson2.setPassword("1234");

        Page<Person> expectedPeople = new PageImpl<>(List.of(expectedPerson,expectedPerson2));
        given(personRepository.findAll(PageRequest.of(offset, pageSize))).willReturn(expectedPeople);

        // WHEN
        Page<Person> actualPeople = personService.getPeoplePagination(offset, pageSize);

        // THEN
        assertEquals(expectedPeople, actualPeople);
        verify(personRepository, times(1)).findAll(PageRequest.of(offset, pageSize));
    }
}

