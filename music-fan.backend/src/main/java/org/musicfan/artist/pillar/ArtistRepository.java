package org.musicfan.artist.pillar;

import org.musicfan.artist.Artist;
import org.musicfan.artist.pillar.mockDB.MockDB;

import java.util.List;

public class ArtistRepository {
    private MockDB mockDB;

    public ArtistRepository(MockDB mockDB) {
        this.mockDB = mockDB;
    }

    public List<Artist> getAllArtists() {
        return mockDB.getAllArtists();
    }

    // TODO: manage orElseThrow
    public Artist getArtistById(String id) {
        return mockDB.getArtistById(id);
    }
}
