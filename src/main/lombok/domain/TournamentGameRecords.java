package domain;

import lombok.Data;

import java.util.List;

@Data
public class TournamentGameRecords {
    private Long id;
    private List<Move> moves;
    private Player player1;
    private Player player2;
}