package org.musicfan.artist.pillar;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class ArtistControllerTest {
    private ArtistService artistService = mock(ArtistService.class);
    private ArtistController artistController = new ArtistController(artistService);

    @Test
    public void should_invoke_artistService_on_getAllArtists() {
        // when
        artistController.getAllArtists();

        // then
        verify(artistService, times(1)).getAllArtists();
    }
}
