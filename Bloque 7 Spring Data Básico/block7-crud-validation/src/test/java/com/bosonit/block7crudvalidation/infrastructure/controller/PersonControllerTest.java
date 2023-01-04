package com.bosonit.block7crudvalidation.infrastructure.controller;

import com.bosonit.block7crudvalidation.domain.entity.Person;
import com.bosonit.block7crudvalidation.domain.repository.PersonRepository;
import com.bosonit.block7crudvalidation.infrastructure.controller.dto.input.PersonInputDto;
import com.bosonit.block7crudvalidation.infrastructure.controller.dto.output.PersonOutputDto;
import com.bosonit.block7crudvalidation.infrastructure.mapper.PersonMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class PersonControllerTest {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @AfterEach
    void tearDown() {
        personRepository.deleteAll();
    }

    Person savePerson() {
        Person person = new Person();
        person.setName("Marta");
        person.setPassword("1234");
        return personRepository.save(person);
    }

    @Test
    void addPerson() throws Exception {
        // GIVEN
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setName("Rafa");
        personInputDto.setPassword("5678");
        personInputDto.setPersonal_email("rafa@gmail.com");
        personInputDto.setActive(false);
        personInputDto.setCity("Alicante");
        personInputDto.setPersonal_email("rafa@bosonit.com");
        personInputDto.setImagen_url("https://image2.jpg");
        personInputDto.setUsuario("rafael");

        // WHEN
        mockMvc.perform(post("/persona")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(personInputDto))
        ).andExpect(status().isCreated());

        // THEN
        assertThat(personRepository.findAll().size()).isOne();
//        Person actualPerson = personRepository.findAll().get(0);


    }

    @Test
    void updatePerson() throws Exception {
        // GIVEN
        Person person = savePerson();
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setName("Rafa");
        personInputDto.setPassword("5678");
        personInputDto.setPersonal_email("rafa@gmail.com");
        personInputDto.setActive(false);
        personInputDto.setCity("Alicante");
        personInputDto.setPersonal_email("rafa@bosonit.com");
        personInputDto.setImagen_url("https://image2.jpg");
        personInputDto.setUsuario("rafael");

        // WHEN
        MvcResult mvcResult =
            mockMvc.perform(put("/persona/" + person.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(personInputDto))
            ).andExpect(status().isOk()).andReturn();

        // THEN
        Person actualPerson = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Person.class);
        Person expectedPerson = PersonMapper.Instance.personInputDtoToPerson(personInputDto);
        expectedPerson.setId(person.getId());
        expectedPerson.setCreated_date(actualPerson.getCreated_date());
        assertThat(actualPerson).isEqualTo(expectedPerson);
    }

    @Test
    void deletePersonById() throws Exception {
        // GIVEN
        Person person = savePerson();

        // WHEN
        MvcResult mvcResult =
                mockMvc.perform(delete("/persona/" + person.getId())
                ).andExpect(status().isOk()).andReturn();

        // THEN
        String message = mvcResult.getResponse().getContentAsString();
        assertThat(message).isEqualTo("Persona con id: "+ person.getId() +" ha sido eliminada");
        assertThat(personRepository.count()).isZero();
    }

    @Test
    void deletePersonByIdNotExists() throws Exception {
        // GIVEN
        Person person = savePerson();

        // WHEN
        MvcResult mvcResult =
                mockMvc.perform(delete("/persona/" + person.getId() + 1)
                ).andExpect(status().isNotFound()).andReturn();

        // THEN
        String message = mvcResult.getResponse().getContentAsString();
        assertThat(message).isEqualTo(HttpStatus.NOT_FOUND + ": Persona no encontrada");
        assertThat(personRepository.count()).isOne();
    }

    @Test
    void getPersonById() throws Exception {
        // GIVEN
        Person person = savePerson();

        // WHEN
        MvcResult mvcResult =
                mockMvc.perform(get("/persona/" + person.getId())
                ).andExpect(status().isOk()).andReturn();

        // THEN
        Person actualPerson = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Person.class);
        assertThat(actualPerson).isEqualTo(person);
    }

    @Test
    void getPersonByIdNotExists() throws Exception {
        // GIVEN
        Person person = savePerson();

        // WHEN
        MvcResult mvcResult =
                mockMvc.perform(get("/persona/" + person.getId() + 1)
                ).andExpect(status().isNotFound()).andReturn();

        // THEN
        String message = mvcResult.getResponse().getContentAsString();
        assertThat(message).isEqualTo(HttpStatus.NOT_FOUND + ": Persona no encontrada");
    }

    @Test
    void getPeople() throws Exception {
        // GIVEN
        Person person1 = savePerson();
        Person person2 = savePerson();

        // WHEN
        MvcResult mvcResult =
                mockMvc.perform(get("/persona/personas")
                ).andExpect(status().isOk()).andReturn();

        // THEN
        List<Person> actualPersons = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<>() {});
        List<Person> expectedPersons = List.of(person1,person2);
        assertThat(actualPersons).isEqualTo(expectedPersons);
    }

    @Test
    void searchAllWithPagination() throws Exception {
        // GIVEN
        Person person1 = savePerson();
        Person person2 = savePerson();

        // WHEN
        MvcResult mvcResult =
                mockMvc.perform(get("/persona/paginated")
                        .param("offset","0")
                        .param("pageSize", "1")
                ).andExpect(status().isOk()).andReturn();

        // THEN
        PersonOutputDto personOutputDto = PersonMapper.Instance.personToPersonOutputDto(person1);
        Page<PersonOutputDto> expectedPersonPage = new PageImpl<>(List.of(personOutputDto));
        String expectedJSONPerson = objectMapper.writeValueAsString(expectedPersonPage.getContent());
        String actualJSONPerson = mvcResult.getResponse().getContentAsString();

        assertThat(actualJSONPerson).contains(expectedJSONPerson);
    }
}