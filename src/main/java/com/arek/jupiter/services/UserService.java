package com.arek.jupiter.services;

import com.arek.jupiter.entities.User;
import com.arek.jupiter.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Streamable<User> getAllUsers() {
        return Streamable.of(userRepository.findAll());
    }

    public Optional<User> getUserById(final int id) {
        return userRepository.findById(id);
    }
}
