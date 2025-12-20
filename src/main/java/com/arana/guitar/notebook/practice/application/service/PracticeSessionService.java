package com.arana.guitar.notebook.practice.application.service;
import com.arana.guitar.notebook.practice.domain.models.*;
import com.arana.guitar.notebook.practice.domain.repo.PracticeSessionRepository;
import com.arana.guitar.notebook.practice.domain.repo.SongRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PracticeSessionService {

    private final PracticeSessionRepository practiceSessionRepository;
    private final SongRepository songRepository;

    public PracticeSessionService(PracticeSessionRepository practiceSessionRepository,
                                  SongRepository songRepository) {
        this.practiceSessionRepository = practiceSessionRepository;
        this.songRepository = songRepository;
    }

    public List<PracticeSession> findAll() {
        return practiceSessionRepository.findAll();
    }

    public Optional<PracticeSession> findById(Long id) {
        return practiceSessionRepository.findById(id);
    }

    //dto here
    public PracticeSession create(@NotNull List<Long> songIds,
                         @NotBlank String name, @NotNull User owner) {

        PracticeSession session = new PracticeSession(owner, name);
        List<Song> songs = songRepository.findAllById(songIds);
        if (songs.size() != songIds.size()) {
            throw new IllegalArgumentException("Some songs were not found");
        }

        for (int i = 0; i < songs.size(); i++) {
            session.addSong(songs.get(i), i);
        }

        return practiceSessionRepository.save(session);
    }

    public boolean deleteById(Long id) {
        if (!practiceSessionRepository.existsById(id)) return false;
        practiceSessionRepository.deleteById(id);
        return true;
    }

    @Transactional
    public Optional<PracticeSession> update(Long id,
                                            @NotNull List<Long> songIds,
                                            @NotBlank String name) {
        return practiceSessionRepository.findById(id).map(session ->
        {
            session.setName(name);
            List<Song> songs = songRepository.findAllById(songIds);
            session.replaceSongs(songs);
            return practiceSessionRepository.save(session);
        });

    }


}
