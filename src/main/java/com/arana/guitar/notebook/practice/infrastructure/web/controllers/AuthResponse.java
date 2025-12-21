package com.arana.guitar.notebook.practice.infrastructure.web.controllers;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    @NotBlank
    private String token;
}
