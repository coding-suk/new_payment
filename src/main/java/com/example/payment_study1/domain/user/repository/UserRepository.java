package com.example.payment_study1.domain.user.repository;

import com.example.payment_study1.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
