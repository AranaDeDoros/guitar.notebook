package com.arana.guitar.notebook.practice.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongCreate {
    @NotBlank
    private String publicId;
    @NotBlank
    private String title;
    @NotBlank
    //publicId
    private String artist;
    @NotBlank
    private String video;
    @NotBlank
    //publicId
    private String tabUrl;
    @NotBlank
    private String comment;
    @PositiveOrZero
    private int progress;
}
