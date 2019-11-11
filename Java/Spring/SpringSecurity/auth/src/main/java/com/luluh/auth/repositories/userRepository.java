package com.luluh.auth.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.luluh.auth.models.User;

@Repository
public interface userRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}

