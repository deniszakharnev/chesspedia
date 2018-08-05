package domain;

import lombok.Data;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Data
public class Tournament {
    private Long id;
    private String name;
    private Date startDate;
    private List<Player> players;
}
