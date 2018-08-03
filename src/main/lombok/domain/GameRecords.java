package domain;

import lombok.Data;

import java.util.List;

@Data
public class GameRecords {
    private Long id;
    private GameType type;
    private String name;
    private List<Move> moves;
}