package org.musicfan.artist.pillar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.musicfan.artist.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArtistControllerIT {
    @LocalServerPort
    private int port;
    private URL baseUrl;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() throws MalformedURLException {
        baseUrl = new URL("http://localhost:" + port + "/music-fan/artists");

        jdbcTemplate.execute("DROP TABLE artists IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE artists(id VARCHAR(2), full_name VARCHAR(255), path_to_main_picture VARCHAR(255))");
        jdbcTemplate.execute("INSERT INTO artists(id, full_name, path_to_main_picture) VALUES ('ID','full name','path to main picture')");
        jdbcTemplate.query("SELECT * FROM artists",
                (rs, rowNum) -> new Artist(
                        rs.getString("id"),
                        rs.getNString("full_name"),
                        rs.getNString("path_to_main_picture")))
                .forEach(artist -> System.out.println("initiated: " + artist));
    }

    @Test
    public void should_get_all_artists() {
        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl.toString(), String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("[{\"id\":\"ID\",\"fullName\":\"full name\",\"pathToMainPicture\":\"path to main picture\"}]");
    }
}
