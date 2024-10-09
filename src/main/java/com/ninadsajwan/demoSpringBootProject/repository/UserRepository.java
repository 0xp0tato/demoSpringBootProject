package com.ninadsajwan.demoSpringBootProject.repository;

import com.ninadsajwan.demoSpringBootProject.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<UserEntity, UUID> {

    UserEntity findByEmail(String email);

}
