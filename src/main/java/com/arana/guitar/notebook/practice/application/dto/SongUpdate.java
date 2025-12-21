package com.arana.guitar.notebook.practice.application.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongUpdate {
    //for now, only the progress will be updated
    @NotBlank
    private String id;
    @PositiveOrZero
    private int progress;
}
