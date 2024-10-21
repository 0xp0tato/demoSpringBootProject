package com.ninadsajwan.demoSpringBootProject.service;

import com.ninadsajwan.demoSpringBootProject.dto.CreateUserDTO;
import com.ninadsajwan.demoSpringBootProject.dto.UpdateUserDTO;
import com.ninadsajwan.demoSpringBootProject.dto.response.CreateUserResponseDTO;
import com.ninadsajwan.demoSpringBootProject.entity.UserEntity;
import com.ninadsajwan.demoSpringBootProject.exceptions.CannotCreateUserException;
import com.ninadsajwan.demoSpringBootProject.exceptions.CannotDeleteUserException;
import com.ninadsajwan.demoSpringBootProject.exceptions.CannotUpdateUserException;
import com.ninadsajwan.demoSpringBootProject.exceptions.NoUserFoundException;
import com.ninadsajwan.demoSpringBootProject.repository.UserRepository;
import com.ninadsajwan.demoSpringBootProject.utils.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAllTopics() {
        List<UserEntity> users = (List<UserEntity>) userRepository.findAll();

        if (users.isEmpty()) throw new NoUserFoundException();

        return users;
    }

    public CreateUserResponseDTO addUser(CreateUserDTO user) {
        try {
            UserEntity newUser = UserMapper.INSTANCE.CreateUser(user);
            userRepository.save(newUser);

            return UserMapper.INSTANCE.CreateUserSuccess(newUser);
        } catch (Exception e) {
            throw new CannotCreateUserException();
        }
    }

    public UserEntity updateUser(UUID id, UpdateUserDTO updatedUser) {

        Optional<UserEntity> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            UserEntity userToUpdate = existingUser.get();
            UserMapper.INSTANCE.UpdateUser(updatedUser, userToUpdate);

            return userRepository.save(userToUpdate);
        }

        throw new CannotUpdateUserException(id);
    }

    public UserEntity deleteUser(UUID id) {

        Optional<UserEntity> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            UserEntity user = existingUser.get();
            userRepository.delete(user);
            return user;
        }

        throw new CannotDeleteUserException(id);
    }
}
