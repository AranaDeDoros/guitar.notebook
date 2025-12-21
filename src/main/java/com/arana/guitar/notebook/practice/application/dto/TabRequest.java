package com.arana.guitar.notebook.practice.application.dto;

import com.arana.guitar.notebook.practice.domain.models.enums.TabSource;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TabRequest {
    @NotNull
    private TabSource source;
    @NotNull
    private Tab tab;
}
