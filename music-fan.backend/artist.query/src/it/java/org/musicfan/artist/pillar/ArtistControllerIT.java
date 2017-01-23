package org.musicfan.artist.pillar;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.List;

import static com.google.common.collect.ImmutableList.of;
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

    private Artist mockArtist = new Artist("ID", "full name", "path to main picture");
    private List<Artist> mockArtists = of(mockArtist);

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws MalformedURLException {
        setUpBaseUrl();
        setUpDB();
    }

    @Test
    public void should_get_all_artists() throws JsonProcessingException {
        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl.toString(), String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(jsonOf(mockArtists));
    }

    @Test
    public void should_get_artist_by_id() throws JsonProcessingException {
        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl.toString() + "/ID", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(jsonOf(mockArtist));
    }

    @Test
    public void should_get_an_artist_not_found_exception() {
        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl.toString() + "/WAT", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody()).contains("\"message\":\"Artist with id \'WAT\' not found\"");
    }

    private void setUpBaseUrl() throws MalformedURLException {
        baseUrl = new URL("http://localhost:" + port + "/music-fan/artists");
    }

    private void setUpDB() {
        jdbcTemplate.execute("TRUNCATE TABLE ARTISTS");
        jdbcTemplate.execute("INSERT INTO artists(id, full_name, path_to_main_picture) VALUES ('ID','full name','path to main picture')");
        jdbcTemplate.query("SELECT * FROM artists",
                (rs, rowNum) -> new Artist(
                        rs.getString("id"),
                        rs.getNString("full_name"),
                        rs.getNString("path_to_main_picture")))
                .forEach(artist -> System.out.println("initiated: " + artist));
    }

    private String jsonOf(Object response) throws JsonProcessingException {
        return mapper.writeValueAsString(response);
    }
}
