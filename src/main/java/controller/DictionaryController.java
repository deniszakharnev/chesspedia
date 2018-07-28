package controller;

import domain.Country;
import domain.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.Dictionary;

import java.util.Optional;

@RestController
@Slf4j
public class DictionaryController {

    @Autowired
    private Dictionary dictionary;

    @RequestMapping(value = "/dictionary/country/", method = RequestMethod.POST)
    public ResponseEntity<?> createCountry(@RequestParam("name") String name, @RequestParam("shortname") String shortName) {

        Country country = new Country();
        country.setName(name);
        country.setShortName(shortName);
        try {
            dictionary.createCountry(country);
            return new ResponseEntity<>(country, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error while creating country: {}", country, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/dictionary/country/{shortname}", method = RequestMethod.GET)
    public ResponseEntity<?> findCountryByShortName(@PathVariable("shortname") String shortName) {
        Optional<Country> country = dictionary.findCountryByShortName(shortName);
        if (country.isPresent()) {
            return ResponseEntity.ok(country.get());
        } else {
            return new ResponseEntity<>("Can't find country " + shortName, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/dictionary/player/", method = RequestMethod.POST)
    public ResponseEntity<?> createPlayer(@RequestParam("name") String name, @RequestParam("countryname") String countryShortName) {

        Player player = new Player();
        player.setName(name);
        try {
            dictionary.createPlayer(player, countryShortName);
            return new ResponseEntity<>(player, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error while creating player: {}", player, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/dictionary/player/{playerId}", method = RequestMethod.GET)
    public ResponseEntity<?> findPlayerById(@PathVariable("playerId") Long playerId) {
        Optional<Player> player = dictionary.findPlayerById(playerId);
        if (player.isPresent()) {
            return ResponseEntity.ok(player.get());
        } else {
            return new ResponseEntity<>("Can't find player by id " + playerId, HttpStatus.BAD_REQUEST);
        }
    }
}
