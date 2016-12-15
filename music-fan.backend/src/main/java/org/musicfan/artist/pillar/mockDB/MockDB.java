package org.musicfan.artist.pillar.mockDB;

import org.musicfan.artist.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class MockDB {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void initMock() {
        jdbcTemplate.execute("DROP TABLE artists IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE artists(id VARCHAR(2), full_name VARCHAR(255), path_to_main_picture VARCHAR(255))");
        jdbcTemplate.execute("INSERT INTO artists(id, full_name, path_to_main_picture) VALUES ('ID','Dave Matthews','path to favorite picture')");
        jdbcTemplate.query("SELECT * FROM artists",
                (rs, rowNum) -> new Artist(
                        rs.getString("id"),
                        rs.getNString("full_name"),
                        rs.getNString("path_to_main_picture")))
                .forEach(artist -> System.out.println("initiated: " + artist));
    }

    public List<Artist> getAllArtists() {
        return jdbcTemplate.query("SELECT * FROM artists",
                (rs, rowNum) -> new Artist(
                        rs.getString("id"),
                        rs.getNString("full_name"),
                        rs.getNString("path_to_main_picture")));
    }
}
