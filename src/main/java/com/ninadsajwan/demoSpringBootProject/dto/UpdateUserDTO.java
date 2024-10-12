package com.ninadsajwan.demoSpringBootProject.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class UpdateUserDTO {
    private String name;

    @Email(message = "Email should be valid")
    private String email;
    private String contact;
    private Boolean status;
}
