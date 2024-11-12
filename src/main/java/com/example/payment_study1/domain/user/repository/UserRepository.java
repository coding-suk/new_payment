package com.example.payment_study1.domain.user.repository;

import com.example.payment_study1.domain.user.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(@NotBlank @Email String email);

    Optional<User> findByEmail(String email);
}
