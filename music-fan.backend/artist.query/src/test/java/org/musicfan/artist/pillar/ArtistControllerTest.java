package org.musicfan.artist.pillar;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ArtistControllerTest {
    private ArtistService artistService = mock(ArtistService.class);
    private ArtistController artistController = new ArtistController(artistService);

    @Test
    public void should_invoke_artist_service_on_getAllArtists() {
        // when
        artistController.getAllArtists();

        // then
        verify(artistService, times(1)).getAllArtists();
    }

    @Test
    public void should_invoke_artist_service_on_getArtistById() {
        // given
        String artistId = "artist_id";

        // when
        artistController.getArtistById(artistId);

        // then
        verify(artistService, times(1)).getArtistById(artistId);
    }
}
