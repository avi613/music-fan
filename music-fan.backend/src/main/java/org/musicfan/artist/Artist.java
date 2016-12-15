package org.musicfan.artist;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Value;
import org.musicfan.artist.views.ArtistView;

@Value
public class Artist {
    @JsonView(ArtistView.class)
    private String id;
    @JsonView(ArtistView.class)
    private String fullName;
    @JsonView(ArtistView.class)
    private String pathToMainPicture;
}
