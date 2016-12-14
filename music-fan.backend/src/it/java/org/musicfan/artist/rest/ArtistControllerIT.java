package org.musicfan.artist.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Before
    public void setUp() throws MalformedURLException {
        baseUrl = new URL("http://localhost:" + port + "/artists");
    }

    @Test
    public void should_get_all_artists() {
        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl.toString(), String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("[{\"id\":\"1\",\"name\":\"Serges Gainsbourg\"},{\"id\":\"2\",\"name\":\"Georges Brassens\"},{\"id\":\"3\",\"name\":\"Edit Piaf\"},{\"id\":\"4\",\"name\":\"Neil Young\"},{\"id\":\"5\",\"name\":\"Jimi Hendrix\"}]");
    }
}
