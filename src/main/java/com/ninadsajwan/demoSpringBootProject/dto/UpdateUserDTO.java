package com.ninadsajwan.demoSpringBootProject.dto;

import lombok.Data;

@Data
public class UpdateUserDTO {
    private String name;
    private String email;
    private String contact;
    private Boolean status;
}
