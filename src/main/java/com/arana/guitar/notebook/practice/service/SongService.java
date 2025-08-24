package com.arana.guitar.notebook.practice.service;

import com.arana.guitar.notebook.practice.core.SongV;
import com.arana.guitar.notebook.practice.repo.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    private final SongRepository repo;

    @Autowired
    public SongService(SongRepository songRepository) {
        this.repo = songRepository;
    }

    public List<SongV> All(){
        return repo.findAll();
    }

    public SongV Store(SongV song){
        return repo.save(song);
    }

    public Optional<SongV> Get(Long id) {
        return repo.findById(id);
    }

    public Boolean Delete(Long id) {
        if (!repo.existsById(id)) {
            return false;
        }
        repo.deleteById(id);
        return true;
    }

    public Optional<SongV> Update(Long id, SongV updatedSong) {
        if (!repo.existsById(id)) {
            return Optional.empty();
        }
        return repo.findById(id)
                .map(song -> {
                    song.setTitle(updatedSong.getTitle());
                    song.setArtistId(updatedSong.getArtistId());
                    song.setVideo(updatedSong.getVideo());
                    song.setTabId(updatedSong.getTabId());
                    return repo.save(song);
                });

    }

}
