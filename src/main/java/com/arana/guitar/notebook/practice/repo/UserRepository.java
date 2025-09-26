package com.arana.guitar.notebook.practice.repo;

import com.arana.guitar.notebook.practice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
