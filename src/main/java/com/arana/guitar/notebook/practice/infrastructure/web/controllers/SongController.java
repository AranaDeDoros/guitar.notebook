package com.arana.guitar.notebook.practice.infrastructure.web.controllers;

import com.arana.guitar.notebook.practice.application.dto.SongCreate;
import com.arana.guitar.notebook.practice.application.dto.Song;
import com.arana.guitar.notebook.practice.application.dto.SongUpdate;
import com.arana.guitar.notebook.practice.application.service.SongService;
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
        return service.All();
    }

    @PostMapping("/songs/store")
    public ResponseEntity<Song> create(@RequestBody SongCreate dto) {
        Song created = service.Store(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/songs/{id}/view")
    public ResponseEntity<Song> view(@PathVariable Long id) {
        return service.Get(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/songs/{id}/update")
    public ResponseEntity<Song> update(@PathVariable Long id, @RequestBody SongUpdate dto) {
        return service.Update(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/songs/{id}/delete")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = service.Delete(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
