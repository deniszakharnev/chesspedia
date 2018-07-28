package mybatis;

import domain.Country;
import domain.Player;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DictionaryMapper {

    String SELECT_PLAYER_BY_ID = "SELECT p.*, c.name country_name, c.short_name FROM Player p INNER JOIN Country c ON p.country_id=c.id WHERE p.id = #{playerId}";
    String SELECT_COUNTRY_BY_SHORTNAME = "SELECT * FROM Country WHERE short_name = #{name}";
    String INSERT_COUNTRY = "INSERT INTO Country (name, short_name) VALUES (#{name}, #{shortName})";
    String INSERT_PLAYER = "INSERT INTO Player (name, country_id) VALUES (#{name}, #{country.id})";

    @Insert(INSERT_COUNTRY)
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void createCountry(Country country);

    @Select(SELECT_COUNTRY_BY_SHORTNAME)
    @ResultMap("countryResult")
    Country findCountryByName(@Param("name") String name);

    @Insert(INSERT_PLAYER)
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void createPlayer(Player player);

    @Select(SELECT_PLAYER_BY_ID)
    @ResultMap("playerResult")
    Player findPlayerById(@Param("playerId") Long id);
}
