package service;

import domain.Country;
import domain.Player;
import lombok.extern.slf4j.Slf4j;
import mybatis.DictionaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class Dictionary {

    @Autowired
    private DictionaryMapper dictionary;

    public void createCountry(@NonNull Country country) {
        dictionary.createCountry(country);
        log.info("Country created: {}", country);
    }

    public Optional<Country> findCountryByShortName(String shortName) {
        return Optional.ofNullable(dictionary.findCountryByName(shortName));
    }

    public void createPlayer(Player player, String countryShortName) {
        Optional<Country> country = findCountryByShortName(countryShortName);
        if (!country.isPresent()) {
            throw new IllegalArgumentException("Can't find country by its short name " + countryShortName);
        }

        player.setCountry(country.get());
        dictionary.createPlayer(player);
    }

    public Optional<Player> findPlayerById(Long playerId) {
        return Optional.ofNullable(dictionary.findPlayerById(playerId));
    }
}
