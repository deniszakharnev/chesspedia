package mybatis;

import domain.Player;
import domain.Tournament;
import domain.TournamentGameRecords;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TournamentMapper {

    String FIND_TOURNAMENT_GAME =
            "SELECT " +
                    "tg.game_id game_id, " +
                    "p1.id p1_player_id, " +
                    "p1.name p1_player_name, " +
                    "p1.country_id p1_country_id, " +
                    "c1.name p1_country_name, " +
                    "c1.short_name p1_short_country_name, " +
                    "p2.id p2_player_id, " +
                    "p2.name  p2_player_name, " +
                    "p2.country_id p2_country_id," +
                    "c2.name p2_country_name, " +
                    "c2.short_name p2_short_country_name " +
                    "FROM tournament_game tg " +
                    "LEFT JOIN player p1 ON tg.player1_id=p1.id " +
                    "LEFT JOIN player p2 ON tg.player2_id=p2.id " +
                    "LEFT JOIN country c1 ON p1.country_id=c1.id " +
                    "LEFT JOIN country c2 ON p2.country_id=c2.id " +
                    "WHERE tg.tournament_id=#{tournamentId} AND tg.game_id=#{gameId}";

    String FIND_TOURNAMENT_PLAYERS =
            "SELECT p.* " +
                    "FROM tournament_player tp " +
                    "INNER JOIN player p ON tp.player_id = p.id " +
                    "WHERE tournament_id=#{tournamentId}";

    @Select("SELECT * FROM tournament")
    @ResultMap("tournamentResult")
    List<Tournament> getTournaments();

    @Select(FIND_TOURNAMENT_GAME)
    @ResultMap("tournamentGameResult")
    TournamentGameRecords getTournamentGameRecords(@Param("tournamentId") Long tournamentId, @Param("gameId") Long gameId);

    @Select(FIND_TOURNAMENT_PLAYERS)
    List<Player> getTournamentPlayers(@Param("tournamentId") Long tournamentId);
}
