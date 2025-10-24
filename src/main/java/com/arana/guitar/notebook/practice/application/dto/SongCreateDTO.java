package com.arana.guitar.notebook.practice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongCreateDTO {
    private String title;
    private Long artistId;
    private String video;
    private String tabUrl;
    private String comment;
    private int progress;
}
