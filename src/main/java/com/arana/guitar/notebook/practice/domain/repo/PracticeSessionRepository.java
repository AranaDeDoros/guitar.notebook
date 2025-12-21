package com.arana.guitar.notebook.practice.domain.repo;

import com.arana.guitar.notebook.practice.domain.models.PracticeSession;
import com.arana.guitar.notebook.practice.domain.models.SessionSong;
import com.arana.guitar.notebook.practice.domain.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PracticeSessionRepository extends JpaRepository<PracticeSession,Long>{
    Optional<Song> findByPublicId(String id);
}
