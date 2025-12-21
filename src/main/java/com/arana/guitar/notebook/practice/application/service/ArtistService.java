package com.arana.guitar.notebook.practice.application.service;

import com.arana.guitar.notebook.practice.application.dto.ArtistCreate;
import com.arana.guitar.notebook.practice.domain.models.Artist;
import com.arana.guitar.notebook.practice.domain.models.Song;
import com.arana.guitar.notebook.practice.domain.repo.ArtistRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository ) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    public Optional<Artist> findById(Long id) {
        return artistRepository.findById(id);
    }

    //just the artist
    public Artist create(ArtistCreate artistDTO) {
        Artist newArtist = new  Artist(
                null,
                null,
                artistDTO.getName(),
                new ArrayList<Song>()
        );

        return artistRepository.save(newArtist);
    }

    public boolean deleteById(Long id) {
        if (!artistRepository.existsById(id)) return false;
        artistRepository.deleteById(id);
        return true;
    }

    @Transactional
    public Optional<Artist> update(Long id,
                                   Artist previousArtist
                                           ) {
        return artistRepository.findById(id).map(artist ->
        {
            artist.setName(previousArtist.getName());
            artist.setSongs(previousArtist.getSongs());
            return artistRepository.save(artist);
        });

    }
}


