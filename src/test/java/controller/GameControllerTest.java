package controller;

import app.ChesspediaApplication;
import domain.*;
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
public class GameControllerTest {

    public static final long GAME_ID = 1L;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGameRecords() {
        ResponseEntity<GameRecords> response = restTemplate.getForEntity(
                "/game/" + GAME_ID,
                GameRecords.class
        );

        assertThat(response, notNullValue());
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), notNullValue());

        GameRecords gameRecords = response.getBody();
        assertThat(gameRecords.getName(), is("Sicilian defense"));
        assertThat(gameRecords.getType(), is(GameType.TUTORIAL));

        assertThat(gameRecords.getMoves(), notNullValue());
        assertThat(gameRecords.getMoves().size(), is(2));

        Move move1 = gameRecords.getMoves().get(0);
        assertThat(move1.getColor(), is(Color.WHITE));
        assertThat(move1.getPiece(), is(Piece.PAWN));
        assertThat(move1.getMoveFrom(), is("e2"));
        assertThat(move1.getMoveTo(), is("e4"));

        Move move2 = gameRecords.getMoves().get(1);
        assertThat(move2.getColor(), is(Color.BLACK));
        assertThat(move2.getPiece(), is(Piece.PAWN));
        assertThat(move2.getMoveFrom(), is("c7"));
        assertThat(move2.getMoveTo(), is("c5"));
    }
}
