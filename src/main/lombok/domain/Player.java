package domain;

import lombok.Data;

@Data
public class Player {
    private Long id;
    private String name;
    private Country country;
}
