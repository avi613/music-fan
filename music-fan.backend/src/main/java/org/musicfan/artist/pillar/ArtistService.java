package org.musicfan.artist.pillar;

import com.google.common.collect.ImmutableList;
import org.musicfan.artist.Artist;

import java.util.List;

public class ArtistService {
    private ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> getAllArtists() {
        return artistRepository.getAllArtists();
    }
}
