package com.arek.jupiter.controllers;

import com.arek.jupiter.dtos.UserDto;
import com.arek.jupiter.entities.User;
import com.arek.jupiter.mappers.UserMapper;
import com.arek.jupiter.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        final List<User> users = userService.getAllUsers()
                .toList();
        return ResponseEntity.ok(users);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") final int id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path = "/dto")
    public ResponseEntity<List<UserDto>> getAllUsersDto() {
        final List<UserDto> usersDto = userService.getAllUsers()
                .map(userMapper::userToUserDto)
                .toList();
        return ResponseEntity.ok(usersDto);
    }
}
