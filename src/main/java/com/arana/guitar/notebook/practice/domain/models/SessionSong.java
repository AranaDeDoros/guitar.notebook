package com.arana.guitar.notebook.practice.domain.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "session_songs")
public class SessionSong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "session_id")
    private PracticeSession session;

    @ManyToOne(optional = false)
    @JoinColumn(name = "song_id")
    private Song song;

    @Column(nullable = false)
    private int orderIndex;

    public SessionSong(PracticeSession session, Song song, int orderIndex) {
        this.session = session;
        this.song = song;
        this.orderIndex = orderIndex;
    }
}
