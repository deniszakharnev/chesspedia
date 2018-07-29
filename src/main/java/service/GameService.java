package service;

import domain.GameRecords;
import mybatis.GameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameMapper gameMapper;

    public GameRecords loadGameRecords(Long gameId) {
        return gameMapper.loadGameRecords(gameId);
    }
}
