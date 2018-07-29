package domain;

import lombok.Data;

@Data
public class GameRecords {
    private Long id;
    private GameType type;
    private String name;
}