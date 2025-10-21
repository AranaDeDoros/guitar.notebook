package com.arana.guitar.notebook.practice.service;

import com.arana.guitar.notebook.practice.dto.*;
import com.arana.guitar.notebook.practice.models.*;
import com.arana.guitar.notebook.practice.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    private final SongRepository songRepo;
    private final ArtistRepository artistRepo;
    private final TabRepository tabRepo;

    @Autowired
    public SongService(SongRepository songRepo, ArtistRepository artistRepo, TabRepository tabRepo) {
        this.songRepo = songRepo;
        this.artistRepo = artistRepo;
        this.tabRepo = tabRepo;
    }

    public List<SongDTO> All() {
        return songRepo.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public Optional<SongDTO> Get(Long id) {
        return songRepo.findById(id).map(this::toDTO);
    }

    public SongDTO Store(SongCreateDTO dto) {
        Artist artist = artistRepo.findById(dto.getArtistId())
                .orElseThrow(() -> new RuntimeException("Artist not found"));

        Tab tab = new Tab();
        tab.setUrl(dto.getTabUrl());

        Song song = new Song();
        song.setTitle(dto.getTitle());
        song.setArtist(artist);
        song.setVideo(dto.getVideo());
        song.setTab(tab);

        Song saved = songRepo.save(song);
        return toDTO(saved);
    }

    public boolean Delete(Long id) {
        if (!songRepo.existsById(id)) return false;
        songRepo.deleteById(id);
        return true;
    }

    public Optional<SongDTO> Update(Long id, SongCreateDTO dto) {
        return songRepo.findById(id).map(song -> {
            song.setTitle(dto.getTitle());
            song.setVideo(dto.getVideo());
            if (dto.getArtistId() != null) {
                artistRepo.findById(dto.getArtistId()).ifPresent(song::setArtist);
            }
            if (dto.getTabUrl() != null) {
                if (song.getTab() == null) song.setTab(new Tab());
                song.getTab().setUrl(dto.getTabUrl());
            }
            Song updated = songRepo.save(song);
            return toDTO(updated);
        });
    }

    private SongDTO toDTO(Song song) {
        ArtistDTO artistDTO = new ArtistDTO(song.getArtist().getId(), song.getArtist().getName());
        TabDTO tabDTO = song.getTab() != null ? new TabDTO(song.getTab().getId(), song.getTab().getUrl()) : null;
        return new SongDTO(song.getId(), song.getTitle(), artistDTO, song.getVideo(), tabDTO);
    }
}
