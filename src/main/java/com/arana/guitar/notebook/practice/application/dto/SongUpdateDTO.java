package com.arana.guitar.notebook.practice.application.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongUpdateDTO {
    //for now, only the progress will be updated
    private String id;
    private int progress;
}
