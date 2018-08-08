package service;

import domain.Player;
import domain.Tournament;
import domain.TournamentGameRecords;
import mybatis.GameMapper;
import mybatis.TournamentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {

    @Autowired
    private TournamentMapper tournamentMapper;

    @Autowired
    private GameMapper gameMapper;

    public List<Tournament> getTournaments() {
        List<Tournament> tournaments = tournamentMapper.getTournaments();
        tournaments.stream().forEach(t ->
                t.setPlayers(loadPlayers(t.getId())
                )
        );
        return tournaments;
    }

    private List<Player> loadPlayers(Long tournamentId) {
        return tournamentMapper.getTournamentPlayers(tournamentId);
    }

    public TournamentGameRecords getTournamentGameRecords(Long tournamentId, Long gameId) {
        TournamentGameRecords gameRecords = tournamentMapper.getTournamentGameRecords(tournamentId, gameId);

        gameRecords.setMoves(gameMapper.loadGameMoves(gameId));

        return gameRecords;
    }
}
