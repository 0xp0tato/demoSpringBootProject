package com.ninadsajwan.demoSpringBootProject.dto.response;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateUserResponseDTO {
    private UUID id;
    private String name;
    private String email;
    private String contact;
    private Boolean status;
    private final String message = "User Created Successfully";
}
