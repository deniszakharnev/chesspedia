package controller;

import app.ChesspediaApplication;
import domain.Country;
import domain.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ChesspediaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DictionaryControllerTest {

    public static final long PLAYER_ID = 1L;

    public static final long COUNTRY_ID = 2L;
    public static final String COUNTRY_CODE = "NOR";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCountryById() {
        ResponseEntity<Country> response = restTemplate.getForEntity(
                "/dictionary/country/" + COUNTRY_CODE,
                Country.class
        );

        assertThat(response, notNullValue());
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), notNullValue());

        Country country = response.getBody();
        assertThat(country.getId(), is(COUNTRY_ID));
        assertThat(country.getName(), is("Norway"));
        assertThat(country.getShortName(), is("NOR"));
    }

    @Test
    public void testFindPlayerById() {
        ResponseEntity<Player> response = restTemplate.getForEntity(
                "/dictionary/player/" + PLAYER_ID,
                Player.class
        );

        assertThat(response, notNullValue());
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), notNullValue());

        Player player = response.getBody();
        assertThat(player.getId(), is(PLAYER_ID));
        assertThat(player.getName(), is("Magnus Carlson"));

        assertThat(player.getCountry(), notNullValue());
        Country country = player.getCountry();
        assertThat(country.getId(), is(COUNTRY_ID));
        assertThat(country.getName(), is("Norway"));
        assertThat(country.getShortName(), is("NOR"));
    }
}
