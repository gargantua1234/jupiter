package com.arek.application.controllers;

import com.arek.application.services.UserService;
import com.arek.domain.dto.UserDto;
import com.arek.domain.entities.User;
import com.arek.domain.mappers.UserMapper;
import com.arek.library.util.ListUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public final class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        return userService.getAllUsers()
                .toList();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable("id") final int id) {
        return userService.getUserById(id);
    }

    @GetMapping(path = "/dto")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getAllUsersDto() {
        return ListUtils.transform(userService.getAllUsers(), userMapper::userToUserDto);
    }

}
