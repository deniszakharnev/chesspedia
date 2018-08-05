package controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.TournamentService;

@RestController
@Slf4j
public class ToutnamentController {

    @Autowired
    private TournamentService tournamentService;

    @RequestMapping(value = "/tournaments", method = RequestMethod.GET)
    public ResponseEntity<?> loadTournaments() {
        return ResponseEntity.ok(tournamentService.getTournaments());
    }

    @RequestMapping(value = "/tournament/{gameId}", method = RequestMethod.GET)
    public ResponseEntity<?> loadTournamentGameRecords(@PathVariable("gameId") Long gameId) {
        return ResponseEntity.ok(tournamentService.getTournamentGameRecords(gameId));
    }
}
