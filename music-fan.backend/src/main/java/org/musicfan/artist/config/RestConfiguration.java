package org.musicfan.artist.config;

import org.musicfan.artist.pillar.ArtistRepository;
import org.musicfan.artist.pillar.ArtistService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestConfiguration {

    @Bean
    public ArtistRepository artistRepository() {
        return new ArtistRepository();
    }

    @Bean
    public ArtistService artistService() {
        return new ArtistService(artistRepository());
    }
}
