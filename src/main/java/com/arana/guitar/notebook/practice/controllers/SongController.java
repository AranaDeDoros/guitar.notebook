package com.arana.guitar.notebook.practice.controllers;

import com.arana.guitar.notebook.practice.dto.*;
import com.arana.guitar.notebook.practice.service.SongService;
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
    public List<SongDTO> songs() {
        return service.All();
    }

    @PostMapping("/songs/store")
    public ResponseEntity<SongDTO> create(@RequestBody SongCreateDTO dto) {
        SongDTO created = service.Store(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/songs/{id}/view")
    public ResponseEntity<SongDTO> view(@PathVariable Long id) {
        return service.Get(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/songs/{id}/update")
    public ResponseEntity<SongDTO> update(@PathVariable Long id, @RequestBody SongCreateDTO dto) {
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
