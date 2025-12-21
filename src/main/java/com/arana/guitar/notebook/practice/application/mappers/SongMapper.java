package com.arana.guitar.notebook.practice.application.mappers;

import com.arana.guitar.notebook.practice.application.dto.Song;
import com.arana.guitar.notebook.practice.application.dto.Tab;
import com.arana.guitar.notebook.practice.domain.models.*;
import com.arana.guitar.notebook.practice.domain.models.enums.ProgressEnum;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SongMapper {

    public Song toDTO(com.arana.guitar.notebook.practice.domain.models.Song song) {
        if (song == null) return null;

        Tab tabDTO = song.getTab() != null
                ? new Tab(song.getTab().getId(), song.getTab().getUrl(),
                             song.getTab().getComment())
                : null;

        return new Song(
                song.getPublicId(),
                song.getTitle(),
                song.getArtist().getName(),
                song.getVideo(),
                tabDTO,
                song.getProgress() != null ? song.getProgress().getPercentage() : 0
        );
    }

    public com.arana.guitar.notebook.practice.domain.models.Song toEntity(@NotNull Song dto, Artist artist, com.arana.guitar.notebook.practice.domain.models.Tab tab) {
        com.arana.guitar.notebook.practice.domain.models.Song song = new com.arana.guitar.notebook.practice.domain.models.Song();
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
