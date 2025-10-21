package com.arana.guitar.notebook.practice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;
    private String video;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tab_id", unique = true) // Ensures uniqueness at DB level
    private Tab tab;
}
