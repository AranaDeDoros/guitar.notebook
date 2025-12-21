package com.arana.guitar.notebook.practice.application.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtistUpdate {
    @NotBlank
    private String id;
    @NotBlank
    private String name;
}
