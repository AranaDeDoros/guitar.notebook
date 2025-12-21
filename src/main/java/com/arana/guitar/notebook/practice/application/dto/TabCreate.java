package com.arana.guitar.notebook.practice.application.dto;
import com.arana.guitar.notebook.practice.domain.models.enums.TabSource;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TabCreate {
    @NotBlank
    private String url;
    @NotBlank
    private String comment;
    @NotNull
    private TabSource source;
}
