package domain;

import common.Pair;
import lombok.Value;

import java.util.Date;
import java.util.List;

@Value
public class Game {
    private String id;
    private Date date;
    private Player player1;
    private Player player2;
    private List<Pair<Color, String>> moves;
}
