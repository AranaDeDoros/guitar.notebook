package com.arana.guitar.notebook.practice.domain.models;

import com.arana.guitar.notebook.practice.domain.models.enums.TabSource;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tabs")
public class Tab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, updatable = false)
    private String publicId = UUID.randomUUID().toString(); // Public key
    private TabSource source;
    private String url;
    private String comment;

}
