package com.arana.guitar.notebook.practice.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Artist {
    @NotBlank
    private String id;
    @NotBlank
    private String name;
}
