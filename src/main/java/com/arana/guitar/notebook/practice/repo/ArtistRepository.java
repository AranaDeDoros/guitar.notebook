package com.arana.guitar.notebook.practice.repo;

import com.arana.guitar.notebook.practice.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
