package com.arana.guitar.notebook.practice.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Table(name = "app_user")
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;
}
