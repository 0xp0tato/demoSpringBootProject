package com.ninadsajwan.demoSpringBootProject.controller;

import com.ninadsajwan.demoSpringBootProject.dto.CreateUserDTO;
import com.ninadsajwan.demoSpringBootProject.dto.DeleteUserDTO;
import com.ninadsajwan.demoSpringBootProject.dto.UpdateUserDTO;
import com.ninadsajwan.demoSpringBootProject.entity.UserEntity;
import com.ninadsajwan.demoSpringBootProject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllTopics();

    }

    @PostMapping
    public void createUser(@Valid @RequestBody CreateUserDTO user) {
        userService.addUser(user);
    }

    @PatchMapping
    public void updateUser(@RequestParam UUID id, @RequestBody UpdateUserDTO user) {
        userService.updateUser(id, user);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam UUID id) {
        userService.deleteUser(id);
    }
}
