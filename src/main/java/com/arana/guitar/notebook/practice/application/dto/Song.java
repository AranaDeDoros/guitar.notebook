package com.arana.guitar.notebook.practice.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Song {
    @NotBlank
    private String id;
    @NotBlank
    private String title;
    @NotBlank
    private Artist artist;
    @NotBlank
    private String video;
    @NotNull
    private Tab tab;
    @PositiveOrZero
    private int progress;
}
