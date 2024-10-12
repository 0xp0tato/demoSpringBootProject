package com.ninadsajwan.demoSpringBootProject.controller;

import com.ninadsajwan.demoSpringBootProject.dto.CreateUserDTO;
import com.ninadsajwan.demoSpringBootProject.dto.DeleteUserDTO;
import com.ninadsajwan.demoSpringBootProject.dto.UpdateUserDTO;
import com.ninadsajwan.demoSpringBootProject.entity.UserEntity;
import com.ninadsajwan.demoSpringBootProject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public UserEntity createUser(@Valid @RequestBody CreateUserDTO user) {
        return userService.addUser(user);
    }

    @PatchMapping
    public void updateUser(@RequestParam UUID id, @Valid @RequestBody UpdateUserDTO user) {
        userService.updateUser(id, user);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam UUID id) {
        userService.deleteUser(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
