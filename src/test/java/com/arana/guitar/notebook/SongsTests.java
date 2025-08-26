package com.arana.guitar.notebook;

import com.arana.guitar.notebook.practice.core.Artist;
import com.arana.guitar.notebook.practice.core.SongV;
import com.arana.guitar.notebook.practice.core.Tab;
import com.arana.guitar.notebook.practice.service.SongController;
import com.arana.guitar.notebook.practice.service.SongService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(SongController.class)
class SongControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SongService service;

    private SongV sampleSong;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        sampleSong = new SongV(1L, "Test Title", 1L,  "youtube.com", new Tab(1L , ""));
        objectMapper = new ObjectMapper();
    }

    @Test
    void testSongs_returnsAllSongs() throws Exception {
        when(service.All()).thenReturn(List.of(sampleSong));

        mockMvc.perform(get("/api/v1/songs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Test Title"));

        verify(service).Store(any(SongV.class));
        verify(service).All();
    }

    @Test
    void testView_existingId_returnsSong() throws Exception {
        when(service.Get(1L)).thenReturn(Optional.of(sampleSong));

        mockMvc.perform(get("/api/v1/songs/view/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Test Title"));
    }

    @Test
    void testView_nonExistingId_returns404() throws Exception {
        when(service.Get(999L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/songs/view/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDelete_existingId_returns204() throws Exception {
        when(service.Delete(1L)).thenReturn(false); // false = success

        mockMvc.perform(delete("/api/v1/songs/delete/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void testDelete_nonExistingId_returns404() throws Exception {
        when(service.Delete(1L)).thenReturn(true); // true = not found

        mockMvc.perform(delete("/api/v1/songs/delete/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testUpdate_existingId_returnsUpdatedSong() throws Exception {
        SongV updatedSong = new SongV(null, "Updated Title", 2L, "youtube.com", new Tab(1L , ""));
        when(service.Update(eq(1L), any(SongV.class)))
                .thenReturn(Optional.of(new SongV(1L, "Updated Title", 2L, "youtube.com", new Tab(1L , ""))));

        mockMvc.perform(put("/api/v1/songs/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedSong)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated Title"));
    }

    @Test
    void testUpdate_nonExistingId_returns404() throws Exception {
        SongV updatedSong = new SongV(null, "Updated Title", 2L, "youtube.com", new Tab(1L , ""));
        when(service.Update(eq(999L), any(SongV.class))).thenReturn(Optional.empty());

        mockMvc.perform(put("/api/v1/songs/update/999")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedSong)))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreate_returnsOkWhenIdGreaterThanZero() throws Exception {
        SongV input = new SongV(null, "New Song", 1L, "youtube.com", new Tab(1L , ""));
        SongV stored = new SongV(1L, "New Song", 1L, "youtube.com", new Tab(1L , ""));

        when(service.Store(any(SongV.class))).thenReturn(stored);

        mockMvc.perform(post("/api/v1/songs/store")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isOk());
    }

}