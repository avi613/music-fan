package org.musicfan.artist.pillar;

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

    public Artist getArtistById(String id) {
        return artistRepository.getArtistById(id);
    }
}
