package com.arana.guitar.notebook.practice.infrastructure.web.controllers;

import com.arana.guitar.notebook.practice.application.dto.PracticeSessionRequest;
import com.arana.guitar.notebook.practice.application.service.PracticeSessionService;
import com.arana.guitar.notebook.practice.domain.models.PracticeSession;
import com.arana.guitar.notebook.practice.domain.models.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/practices")
public class PracticeSessionController {

    private final PracticeSessionService service;

    public PracticeSessionController(PracticeSessionService service) {
        this.service = service;
    }

    @GetMapping
    public List<PracticeSession> findAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<PracticeSession> create(
            @Valid @RequestBody PracticeSessionRequest request
    ) {
        User owner = getCurrentUser(); // placeholder
        PracticeSession created = service.create(
                request.getSongIds(),
                request.getName(),
                owner
        );
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PracticeSession> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PracticeSession> update(
            @PathVariable Long id,
            @Valid @RequestBody PracticeSessionRequest request
    ) {
        return service.update(id, request.getSongIds(), request.getName())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.deleteById(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    private User getCurrentUser() {
        // TODO: integrate Spring Security
        return new User(null, "test", "test");
    }
}

