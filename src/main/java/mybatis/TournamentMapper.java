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
                    "player1.id player1_id, " +
                    "player1.name player1_name, " +
                    "player2.id player2_id, " +
                    "player2.name  player2_name " +
                    "FROM tournament_game tg " +
                    "LEFT JOIN player player1 ON tg.player1_id=player1.id " +
                    "LEFT JOIN player player2 ON tg.player2_id=player2.id " +
                    "WHERE tg.game_id=#{gameId}";

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
    TournamentGameRecords getTournamentGameRecords(@Param("gameId") Long gameId);

    @Select(FIND_TOURNAMENT_PLAYERS)
    List<Player> getTournamentPlayers(@Param("tournamentId") Long tournamentId);
}
