package com.arana.guitar.notebook.practice.domain.repo;

import com.arana.guitar.notebook.practice.domain.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Optional<Artist> findByPublicId(String publicId);
}
