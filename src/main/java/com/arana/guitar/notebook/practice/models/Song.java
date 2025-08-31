package com.arana.guitar.notebook.practice.models;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Long artistId;
    private String video;
    private Long tabId;



    public Song(Long id, String title, Long artistId, String video, Long tabId) {
        this.id = id;
        this.title = title;
        this.artistId = artistId;
        this.video = video;
        this.tabId = tabId;
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
}
