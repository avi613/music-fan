package org.musicfan.artist.pillar;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.musicfan.artist.Artist;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.google.common.collect.ImmutableList.of;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class ArtistControllerTestWeb {
    private ArtistService artistService = mock(ArtistService.class);
    private MockMvc mockMvc = standaloneSetup(new ArtistController(artistService)).build();

    private Artist mockArtist = new Artist("ID", "full name", "path to main picture");
    private List<Artist> mockArtistList = of(mockArtist);

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void should_return_all_artists_on_url_invocation() throws Exception {
        when(artistService.getAllArtists()).thenReturn(mockArtistList);

        mockMvc.perform(get("/artists").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonValueOf(mockArtistList)));
    }

    @Test
    public void should_return_artist_by_id() throws Exception {
        when(artistService.getArtistById(anyString())).thenReturn(mockArtist);

        mockMvc.perform(get("/artists/ID").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonValueOf(mockArtist)));
    }

    private String jsonValueOf(Object response) throws JsonProcessingException {
        return mapper.writeValueAsString(response);
    }
}
