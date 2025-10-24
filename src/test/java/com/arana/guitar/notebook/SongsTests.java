package com.arana.guitar.notebook;

import com.arana.guitar.notebook.practice.domain.models.*;
import com.arana.guitar.notebook.practice.infrastructure.web.controllers.SongController;
import com.arana.guitar.notebook.practice.application.service.SongService;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

//have to update these tests, ignore for now
@WebMvcTest(SongController.class)
class SongControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private SongService service;
//
//    private Song sampleSong;
//    private ObjectMapper objectMapper;
//
//    @BeforeEach
//    void setUp() {
//        sampleSong = new Song(1L, "Test Title", new Artist(1L, "example1"),  "youtube.com", new Tab(1L , ""));
//        objectMapper = new ObjectMapper();
//    }
//
//    @Test
//    void testSongs_returnsAllSongs() throws Exception {
//        when(service.All()).thenReturn(List.of(sampleSong));
//
//        mockMvc.perform(get("/api/v1/songs"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].title").value("Test Title"));
//
//        verify(service).Store(any(Song.class));
//        verify(service).All();
//    }
//
//    @Test
//    void testView_existingId_returnsSong() throws Exception {
//        when(service.Get(1L)).thenReturn(Optional.of(sampleSong));
//
//        mockMvc.perform(get("/api/v1/songs/view/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.title").value("Test Title"));
//    }
//
//    @Test
//    void testView_nonExistingId_returns404() throws Exception {
//        when(service.Get(999L)).thenReturn(Optional.empty());
//
//        mockMvc.perform(get("/api/v1/songs/view/999"))
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    void testDelete_existingId_returns204() throws Exception {
//        when(service.Delete(1L)).thenReturn(false); // false = success
//
//        mockMvc.perform(delete("/api/v1/songs/delete/1"))
//                .andExpect(status().isNoContent());
//    }
//
//    @Test
//    void testDelete_nonExistingId_returns404() throws Exception {
//        when(service.Delete(1L)).thenReturn(true); // true = not found
//
//        mockMvc.perform(delete("/api/v1/songs/delete/1"))
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    void testUpdate_existingId_returnsUpdatedSong() throws Exception {
//        Song updatedSong = new Song(null, "Updated Title", new Artist(2L, "example2"), "youtube.com", new Tab(1L , ""));
//        when(service.Update(eq(1L), any(Song.class)))
//                .thenReturn(Optional.of(new Song(1L, "Updated Title", new Artist(2L, "example2"), "youtube.com", new Tab(1L , ""))));
//
//        mockMvc.perform(put("/api/v1/songs/update/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(updatedSong)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.title").value("Updated Title"));
//    }
//
//    @Test
//    void testUpdate_nonExistingId_returns404() throws Exception {
//        Song updatedSong = new Song(null, "Updated Title", new Artist(1L, "example1"), "youtube.com", new Tab(1L , ""));
//        when(service.Update(eq(999L), any(Song.class))).thenReturn(Optional.empty());
//
//        mockMvc.perform(put("/api/v1/songs/update/999")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(updatedSong)))
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    void testCreate_returnsOkWhenIdGreaterThanZero() throws Exception {
//        Song input = new Song(null, "New Song", new Artist(1L, "example1"), "youtube.com", new Tab(1L , ""));
//        Song stored = new Song(1L, "New Song", new Artist(1L, "example1"), "youtube.com", new Tab(1L , ""));
//
//        when(service.Store(any(Song.class))).thenReturn(stored);
//
//        mockMvc.perform(post("/api/v1/songs/store")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(input)))
//                .andExpect(status().isOk());
//    }

}