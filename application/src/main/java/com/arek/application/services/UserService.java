package com.arek.application.services;

import com.arek.domain.entities.User;
import com.arek.domain.repositories.UserRepository;
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
