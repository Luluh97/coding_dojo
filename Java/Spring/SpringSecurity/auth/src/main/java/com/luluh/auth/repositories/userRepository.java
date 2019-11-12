package com.luluh.auth.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.luluh.auth.models.User;

@Repository
public interface userRepository extends CrudRepository<User, Long> {
	List<User> findAll();
    User findByUsername(String username);
}

