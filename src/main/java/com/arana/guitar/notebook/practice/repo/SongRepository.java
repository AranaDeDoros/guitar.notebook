package com.arana.guitar.notebook.practice.repo;

import com.arana.guitar.notebook.practice.models.SongV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<SongV, Long> {
}
