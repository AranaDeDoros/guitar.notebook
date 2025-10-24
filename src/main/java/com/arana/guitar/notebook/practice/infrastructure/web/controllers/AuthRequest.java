package com.arana.guitar.notebook.practice.infrastructure.web.controllers;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
