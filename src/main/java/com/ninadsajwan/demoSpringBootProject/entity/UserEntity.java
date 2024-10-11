package com.ninadsajwan.demoSpringBootProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id = UUID.randomUUID();

    private String name;

    private String email;

    private String contact;

    private Boolean status;

    public UserEntity(String name, String email, String contact) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.status = true;
    }
}
