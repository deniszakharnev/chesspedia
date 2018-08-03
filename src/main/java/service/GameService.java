package service;

import domain.GameRecords;
import domain.Move;
import lombok.extern.slf4j.Slf4j;
import mybatis.GameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GameService {

    @Autowired
    private GameMapper gameMapper;

    public GameRecords loadGameRecords(Long gameId) {
        try {
            GameRecords gameRecords = gameMapper.loadGameRecords(gameId);

            List<Move> moves = gameMapper.loadGameMoves(gameId);
            gameRecords.setMoves(moves);

            return gameRecords;
        } catch (Exception e) {
            log.error("Error while loading records for game id {}", gameId, e);
            throw new RuntimeException("Error while loading records for game id " + gameId);
        }
    }
}
