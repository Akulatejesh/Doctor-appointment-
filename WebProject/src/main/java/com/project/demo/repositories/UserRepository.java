package com.project.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}

