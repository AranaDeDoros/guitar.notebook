package com.arana.guitar.notebook.practice.infrastructure.web.controllers;

import com.arana.guitar.notebook.practice.application.dto.SongCreate;
import com.arana.guitar.notebook.practice.application.dto.Song;
import com.arana.guitar.notebook.practice.application.dto.SongUpdate;
import com.arana.guitar.notebook.practice.application.service.SongService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SongController {

    private final SongService service;

    public SongController(SongService service) {
        this.service = service;
    }

    @GetMapping("/songs")
    public List<Song> songs() {
        return service.findAll();
    }

    @PostMapping("/songs/store")
    public ResponseEntity<Song> create(@Valid @RequestBody SongCreate dto) {
        Song created = service.create(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/songs/{id}/view")
    public ResponseEntity<Song> view(@PathVariable String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/songs/{id}/update")
    public ResponseEntity<Song> update(@PathVariable String id, @Valid @RequestBody SongUpdate dto) {
        return service.findById(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/songs/{id}/delete")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = service.deleteById(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
