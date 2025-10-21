package com.arana.guitar.notebook.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongCreateDTO {
    private String title;
    private Long artistId; // referenciado por ID
    private String video;
    private String tabUrl; // en lugar de pasar todo el objeto Tab
}
