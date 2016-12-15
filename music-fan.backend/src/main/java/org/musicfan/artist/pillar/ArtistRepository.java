package org.musicfan.artist.pillar;

import com.google.common.collect.ImmutableList;
import org.musicfan.artist.Artist;

import java.util.List;

public class ArtistRepository {
    public List<Artist> getAllArtists() {
        return ImmutableList.of(
                new Artist("ID", "full name", "path to main picture")
        );
    }
}
