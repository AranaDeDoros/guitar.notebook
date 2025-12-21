package com.arana.guitar.notebook.practice.application.dto;

import com.arana.guitar.notebook.practice.domain.models.enums.TabSource;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TabRequest {
    private TabSource source;
    private Tab tab;
}
