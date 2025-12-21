package com.arana.guitar.notebook.practice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tab {
    private Long id;
    private String url;
    private String comment;
}
