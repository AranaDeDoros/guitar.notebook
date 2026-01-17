package com.arana.guitar.notebook.practice.application.mappers;

import org.springframework.stereotype.Component;

@Component
public class ArtistMapper {
    public com.arana.guitar.notebook.practice.application.dto.Artist toDTO(
            com.arana.guitar.notebook.practice.domain.models.Artist artist) {

        if (artist == null) return null;

        return new com.arana.guitar.notebook.practice.application.dto.Artist(
                artist.getPublicId(),
                artist.getName()
        );
    }
}