package com.arana.guitar.notebook.practice.application.service;

import com.arana.guitar.notebook.practice.application.dto.SongCreateDTO;
import com.arana.guitar.notebook.practice.application.dto.SongDTO;
import com.arana.guitar.notebook.practice.application.dto.SongUpdateDTO;
import com.arana.guitar.notebook.practice.domain.models.Song;
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

    public List<SongDTO> All() {
        return songRepo.findAll()
                .stream()
                .map(songMapper::toDTO)
                .toList();
    }

    public Optional<SongDTO> Get(Long id) {
        return songRepo.findById(id).map(songMapper::toDTO);
    }

    public SongDTO Store(@NotNull SongCreateDTO dto) {
        Artist artist = artistRepo.findById(dto.getArtistId())
                .orElseThrow(() -> new RuntimeException("Artist not found"));

        Tab tab = new Tab();
        tab.setUrl(dto.getTabUrl());
        tab.setComment(dto.getComment());

        Song song = new Song();
        song.setTitle(dto.getTitle());
        song.setArtist(artist);
        song.setVideo(dto.getVideo());
        song.setTab(tab);
        song.setProgress(ProgressEnum.fromPercentage(dto.getProgress()));

        Song saved = songRepo.save(song);
        return songMapper.toDTO(saved);
    }

    public boolean Delete(Long id) {
        if (!songRepo.existsById(id)) return false;
        songRepo.deleteById(id);
        return true;
    }

    public Optional<SongDTO> Update(Long id, SongUpdateDTO dto) {
        return songRepo.findById(id).map(song -> {
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
            Song updated = songRepo.save(song);
            return songMapper.toDTO(updated);
        });
    }


}
