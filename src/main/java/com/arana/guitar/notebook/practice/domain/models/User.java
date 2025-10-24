package com.arana.guitar.notebook.practice.domain.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Table(name = "app_user")
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
}
