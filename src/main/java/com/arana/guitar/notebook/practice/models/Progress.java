package com.arana.guitar.notebook.practice.models;

import com.arana.guitar.notebook.practice.models.enums.ProgressEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "progress")
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProgressEnum level;


    public Progress(ProgressEnum level) {
        this.level = level;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProgressEnum getLevel() {
        return level;
    }

    public void setLevel(ProgressEnum level) {
        this.level = level;
    }
}
