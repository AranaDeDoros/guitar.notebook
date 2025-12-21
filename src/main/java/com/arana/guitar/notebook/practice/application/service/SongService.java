package com.arana.guitar.notebook.practice.application.service;

import com.arana.guitar.notebook.practice.application.dto.SongCreate;
import com.arana.guitar.notebook.practice.application.dto.Song;
import com.arana.guitar.notebook.practice.application.dto.SongUpdate;
import com.arana.guitar.notebook.practice.domain.models.Tab;
import com.arana.guitar.notebook.practice.domain.models.enums.ProgressEnum;
import com.arana.guitar.notebook.practice.application.mappers.SongMapper;
import com.arana.guitar.notebook.practice.domain.repo.ArtistRepository;
import com.arana.guitar.notebook.practice.domain.repo.SongRepository;
import com.arana.guitar.notebook.practice.domain.repo.TabRepository;
import com.arana.guitar.notebook.practice.domain.models.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    private final SongRepository songRepo;
    private final ArtistRepository artistRepo;
    private final TabRepository tabRepo;
    private final SongMapper songMapper;

    @Autowired
    public SongService(SongRepository songRepo, ArtistRepository artistRepo,
                       TabRepository tabRepo, SongMapper songMapper) {
        this.songRepo = songRepo;
        this.artistRepo = artistRepo;
        this.tabRepo = tabRepo;
        this.songMapper = songMapper;
    }

    public List<Song> findAll() {
        return songRepo.findAll()
                .stream()
                .map(songMapper::toDTO)
                .toList();
    }

    public Optional<Song> findById(String id) {
        return songRepo.findByPublicId(id).map(songMapper::toDTO);
    }


    public Song create(@NotNull SongCreate dto) {
        Artist artist = artistRepo.findByPublicId(dto.getPublicId())
                .orElseThrow(() -> new RuntimeException("Artist not found"));

        Tab tab = new Tab();
        tab.setUrl(dto.getTabUrl());
        tab.setComment(dto.getComment());

        com.arana.guitar.notebook.practice.domain.models.Song song = new com.arana.guitar.notebook.practice.domain.models.Song();
        song.setTitle(dto.getTitle());
        song.setArtist(artist);
        song.setVideo(dto.getVideo());
        song.setTab(tab);
        song.setProgress(ProgressEnum.fromPercentage(dto.getProgress()));

        com.arana.guitar.notebook.practice.domain.models.Song saved = songRepo.save(song);
        return songMapper.toDTO(saved);
    }

    public boolean deleteById(Long id) {
        if (!songRepo.existsById(id)) return false;
        songRepo.deleteById(id);
        return true;
    }

    public Optional<Song> findById(String id, SongUpdate dto) {
        return songRepo.findByPublicId(id).map(song -> {
            ProgressEnum progress = ProgressEnum.fromPercentage(dto.getProgress());
            song.setProgress(progress);
            //commented for now
//            song.setTitle(dto.getTitle());
//            song.setVideo(dto.getVideo());
//            if (dto.getArtistId() != null) {
//                artistRepo.findById(dto.getArtistId()).ifPresent(song::setArtist);
//            }
//            if (dto.getTabUrl() != null) {
//                if (song.getTab() == null) song.setTab(new Tab());
//                song.getTab().setUrl(dto.getTabUrl());
//                song.getTab().setComment(dto.getComment());
//            }
            com.arana.guitar.notebook.practice.domain.models.Song updated = songRepo.save(song);
            return songMapper.toDTO(updated);
        });
    }


}
