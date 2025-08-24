package com.arana.guitar.notebook.practice.service;

import com.arana.guitar.notebook.practice.core.SongV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SongController {

    private final SongService service;

    @Autowired
    public SongController(SongService SongService) {
        this.service = SongService;
    }

    @GetMapping("/songs")
    public List<SongV> songs() {
        service.Store(new SongV(null, "Sample Title", 1L, "youtube.com", 1L));
        return service.All();
    }

    @PostMapping("/songs/store")
    public ResponseEntity<SongV> create( @RequestBody SongV song) {
        if(service.Store(song).getId() > 0){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/songs/view/{id}")
    public ResponseEntity<SongV> view(@PathVariable Long id) {
        return service.Get(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/songs/delete/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable Long id) {
        boolean isDeleted = service.Delete(id);
        if (isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/songs/update/{id}")
    public ResponseEntity<SongV> updateSong(@PathVariable Long id, @RequestBody SongV updatedSong) {
        return service.Update(id, updatedSong)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}
