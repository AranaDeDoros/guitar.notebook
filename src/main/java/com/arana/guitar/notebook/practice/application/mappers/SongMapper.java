package com.arana.guitar.notebook.practice.application.mappers;

import com.arana.guitar.notebook.practice.application.dto.SongDTO;
import com.arana.guitar.notebook.practice.application.dto.TabDTO;
import com.arana.guitar.notebook.practice.domain.models.*;
import com.arana.guitar.notebook.practice.domain.models.enums.ProgressEnum;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SongMapper {

    public SongDTO toDTO(Song song) {
        if (song == null) return null;

        TabDTO tabDTO = song.getTab() != null
                ? new TabDTO(song.getTab().getId(), song.getTab().getUrl(), song.getTab().getComment())
                : null;

        return new SongDTO(
                song.getPublicId(),
                song.getTitle(),
                song.getArtist().getName(),
                song.getVideo(),
                tabDTO,
                song.getProgress() != null ? song.getProgress().getPercentage() : 0
        );
    }

    public Song toEntity(SongDTO dto, Artist artist, Tab tab) {
        Song song = new Song();
        song.setArtist(artist);
        song.setTab(tab);
        song.setTitle(dto.getTitle());
        song.setVideo(dto.getVideo());
        song.setProgress(ProgressEnum.fromPercentage(dto.getProgress()));

        if (dto.getId() != null && !dto.getId().isBlank()) {
            song.setPublicId(dto.getId());
        } else {
            song.setPublicId((UUID.randomUUID().toString()));
        }

        return song;

    }
}
