package no.computas.computasdag;

import no.computas.computasdag.helper.CharacterService;
import no.computas.computasdag.helper.MovieCharacter;

import java.util.List;

/**
 * @Author: vda
 */
public class App {
    private static final String SEPARATOR = ":";

    protected CharacterService characterService = new CharacterService();

    protected String combine(List<MovieCharacter> characters, String quote) {
        String replacedQuote = quote;
        for (MovieCharacter character : characters) {
            replacedQuote = replacedQuote.replaceAll(
                    character.getName() + SEPARATOR,
                    String.format("%s (%s)%s", character.getName(), character.getActor(), SEPARATOR));
        }
        return "===QUOTE===\n" + replacedQuote;
    }
}
