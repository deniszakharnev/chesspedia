package domain;

import lombok.Getter;

import java.util.Date;
import java.util.List;

public class Tournament {
    @Getter
    private String id;
    @Getter
    private String name;
    @Getter
    private Date startDate;
    @Getter
    private List<Player> players;
}
