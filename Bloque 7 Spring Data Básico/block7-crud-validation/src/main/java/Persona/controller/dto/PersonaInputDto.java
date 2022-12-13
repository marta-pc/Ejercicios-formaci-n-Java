package Persona.controller.dto;

import lombok.Data;

@Data

public class PersonaInputDto {
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private String imagen_url;

}
