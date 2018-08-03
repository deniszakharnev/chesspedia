package service;

import domain.GameRecords;
import domain.Move;
import mybatis.GameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameMapper gameMapper;

    public GameRecords loadGameRecords(Long gameId) {
        GameRecords gameRecords = gameMapper.loadGameRecords(gameId);

        List<Move> moves = gameMapper.loadGameMoves(gameId);
        gameRecords.setMoves(moves);

        return gameRecords;
    }
}
