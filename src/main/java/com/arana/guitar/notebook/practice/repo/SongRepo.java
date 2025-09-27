package com.arana.guitar.notebook.practice.repo;
import com.arana.guitar.notebook.practice.models.Progress;
import com.arana.guitar.notebook.practice.models.Song;
import com.arana.guitar.notebook.practice.models.enums.ProgressEnum;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public class SongRepo {
    private ArrayList<Song> arr;
    public ArrayList<Song> findAll(){
         arr = new ArrayList<Song>();
           arr.add(
                new Song(1L, "title", 1L, "youtube", 1L, new Progress(ProgressEnum.ADVANCED, ""))
        );
          return arr;
    }

    public Optional<Song> findById(long id){
       arr = new ArrayList<Song>();
        arr.add(
                new Song(1L, "title", 1L, "youtube", 1L, new Progress(ProgressEnum.BEGINNER,""))
        );
        return arr.stream().filter(s -> s.getId() == id).findAny();
    }

    public void remove(long id){
        arr = new ArrayList<Song>();
        arr.add(
                new Song(1L, "title", 1L, "youtube", 1L, new Progress(ProgressEnum.FLUENT,""))
        );
        arr.removeIf(song -> song.getId() == id);
    }

    public Song add(Song song){
        Song ns = new Song(song.getId(), song.getTitle(),
                song.getArtistId(), song.getVideo(), song.getTabId(), song.getProgress());
        arr.add(ns);
        return ns;
    }
}
