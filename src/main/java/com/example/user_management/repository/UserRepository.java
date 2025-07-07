package com.example.user_management.repository;

import com.example.user_management.entity.UserApp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends CrudRepository<UserApp, Long> {
    Optional<UserApp> findByUsername(String username);
}
