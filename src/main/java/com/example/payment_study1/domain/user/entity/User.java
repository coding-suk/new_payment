package com.example.payment_study1.domain.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

//    @Column(nullable = false)
    private String name;

    private String email;

    private String password;

    private Boolean enabled = false;

    @Enumerated(EnumType.STRING)
    @Column
    private UserRole role;

    public User(String email, String password, String name, UserRole role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public User(String name, String email, UserRole role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public void deletedUser(String email, String password) {
        this.enabled = true;
    }

    public void updatedUserRole(UserRole newUserRole) {
        this.role = newUserRole;
    }


}
