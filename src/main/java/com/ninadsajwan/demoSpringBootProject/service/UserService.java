package com.ninadsajwan.demoSpringBootProject.service;

import com.ninadsajwan.demoSpringBootProject.dto.CreateUserDTO;
import com.ninadsajwan.demoSpringBootProject.dto.DeleteUserDTO;
import com.ninadsajwan.demoSpringBootProject.dto.UpdateUserDTO;
import com.ninadsajwan.demoSpringBootProject.entity.UserEntity;
import com.ninadsajwan.demoSpringBootProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAllTopics(){
        return (List<UserEntity>)userRepository.findAll();
    }

    public void addUser(CreateUserDTO user){
        String name = user.getName();
        String email = user.getEmail();
        String contact = user.getContact();

        UserEntity createdUser = new UserEntity(name, email, contact);

        userRepository.save(createdUser);
    }

    public void updateUser(UpdateUserDTO user){
        String name = user.getName();
        String email = user.getEmail();
        String contact = user.getContact();
        Boolean status = user.getStatus();

        UserEntity existingUser = userRepository.findByEmail(email);

        if(existingUser != null){
            if(name != null) existingUser.setName(name);

            if(email != null) existingUser.setEmail(email);

            if(contact != null) existingUser.setContact(contact);

            if(status != null) existingUser.setStatus(status);

            UserEntity updatedUser = userRepository.save(existingUser);
        }
    }

    public void deleteUser(DeleteUserDTO user){
        String email = user.getEmail();

        UserEntity existingUser = userRepository.findByEmail(email);

        userRepository.delete(existingUser);
    }
}
