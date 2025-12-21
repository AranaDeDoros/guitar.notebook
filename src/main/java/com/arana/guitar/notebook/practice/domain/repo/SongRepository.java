package com.arana.guitar.notebook.practice.domain.repo;

import com.arana.guitar.notebook.practice.domain.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    Optional<Song> findByPublicId(String id);
}
