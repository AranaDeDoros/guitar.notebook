package com.arana.guitar.notebook.practice.domain.models;

import com.arana.guitar.notebook.practice.domain.models.enums.ProgressEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, updatable = false)
    private String publicId = UUID.randomUUID().toString(); // Public key


    private String title;
    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;
    private String video;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tab_id", unique = true) // Ensures uniqueness at DB level
    private Tab tab;
    private ProgressEnum progress ;
}
