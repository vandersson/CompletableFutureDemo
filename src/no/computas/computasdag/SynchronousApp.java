package no.computas.computasdag;

import no.computas.computasdag.helper.MovieCharacter;
import no.computas.computasdag.helper.Quotes;

import java.util.List;

public class SynchronousApp extends App {
    public SynchronousApp() {
        List<MovieCharacter> characters = characterService.getCharacters();
        String quote = Quotes.getRandomQuote();
        System.out.println(combine(characters, quote));
    }

    public static void main(String[] args) {
        new SynchronousApp();
    }

}
