package com.arana.guitar.notebook.practice.repo;

import com.arana.guitar.notebook.practice.models.Tab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TabRepository extends JpaRepository<Tab, Long> {
}
