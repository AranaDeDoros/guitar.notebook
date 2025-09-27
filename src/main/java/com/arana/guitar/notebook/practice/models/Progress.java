package com.arana.guitar.notebook.practice.models;

import com.arana.guitar.notebook.practice.models.enums.ProgressEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "progress")
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProgressEnum level;


    public Progress(ProgressEnum level) {
        this.level = level;
    }
    public Progress(ProgressEnum level, String comment) {
        this.level = level;
        this.comment = comment;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }



    public ProgressEnum getLevel() {
        return level;
    }

    public void setLevel(ProgressEnum level) {
        this.level = level;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
