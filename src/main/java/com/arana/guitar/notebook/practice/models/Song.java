package com.arana.guitar.notebook.practice.models;



import jakarta.persistence.*;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Long artistId;
    private String video;
    private Long tabId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "progress_id", nullable = false)
    private Progress progress;



    public Song(Long id, String title, Long artistId, String video, Long tabId, Progress progress) {
        this.id = id;
        this.title = title;
        this.artistId = artistId;
        this.video = video;
        this.tabId = tabId;
        this.progress = progress;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Long getArtistId() { return artistId; }
    public void setArtistId(Long artistId) { this.artistId = artistId; }

    public String getVideo() { return video; }
    public void setVideo(String video) { this.video = video; }

    public Long getTabId() { return tabId; }
    public void setTabId(Long tabId) { this.tabId = tabId; }

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }
}
