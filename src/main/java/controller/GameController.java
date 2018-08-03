package controller;

import domain.GameRecords;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.GameService;

@RestController
@Slf4j
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping(value = "/game/{gameId}", method = RequestMethod.GET)
    public ResponseEntity<?> loadGameRecords(@PathVariable("gameId") Long gameId) {
        try {
            GameRecords gameRecords = gameService.loadGameRecords(gameId);

            return ResponseEntity.ok(gameRecords);
        } catch  (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
