package com.ninadsajwan.demoSpringBootProject.service;

import com.ninadsajwan.demoSpringBootProject.dto.CreateUserDTO;
import com.ninadsajwan.demoSpringBootProject.dto.DeleteUserDTO;
import com.ninadsajwan.demoSpringBootProject.dto.UpdateUserDTO;
import com.ninadsajwan.demoSpringBootProject.entity.UserEntity;
import com.ninadsajwan.demoSpringBootProject.repository.UserRepository;
import com.ninadsajwan.demoSpringBootProject.utils.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAllTopics() {
        return (List<UserEntity>) userRepository.findAll();
    }

    public void addUser(CreateUserDTO user) {
        String name = user.getName();
        String email = user.getEmail();
        String contact = user.getContact();

        UserEntity createdUser = new UserEntity(name, email, contact);

        userRepository.save(createdUser);
    }

    public void updateUser(UUID id, UpdateUserDTO updatedUser) {

        Optional<UserEntity> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            UserEntity userToUpdate = existingUser.get();
            UserMapper.INSTANCE.UpdateUser(updatedUser, userToUpdate);
            UserEntity user = userRepository.save(userToUpdate);
        }
    }

    public void deleteUser(UUID id) {

        Optional<UserEntity> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            UserEntity user = existingUser.get();
            userRepository.delete(user);
        }
    }
}
