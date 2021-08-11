package com.arek.jupiter.repositories;

import com.arek.jupiter.entities.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {
}
