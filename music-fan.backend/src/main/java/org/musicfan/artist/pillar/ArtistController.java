package org.musicfan.artist.pillar;

import org.musicfan.artist.Artist;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistController {
    private ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Artist> getAllArtists() {
        return artistService.getAllArtists();
    }
}
