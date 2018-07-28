package domain;

import lombok.Data;

@Data
public class Player {
    private String id;
    private String name;
    private Country country;
}
