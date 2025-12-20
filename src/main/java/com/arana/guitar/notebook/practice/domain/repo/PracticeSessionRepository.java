package com.arana.guitar.notebook.practice.domain.repo;

import com.arana.guitar.notebook.practice.domain.models.PracticeSession;
import com.arana.guitar.notebook.practice.domain.models.SessionSong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracticeSessionRepository extends JpaRepository<PracticeSession,Long>{
}
