package org.musicfan.artist.config;

import org.musicfan.artist.pillar.ArtistRepository;
import org.musicfan.artist.pillar.ArtistService;
import org.musicfan.artist.pillar.mockDB.MockDB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestConfiguration {
    @Bean
    public MockDB mockDB() {
        return new MockDB();
    }

    @Bean
    public ArtistRepository artistRepository() {
        return new ArtistRepository(mockDB());
    }

    @Bean
    public ArtistService artistService() {
        return new ArtistService(artistRepository());
    }
}
