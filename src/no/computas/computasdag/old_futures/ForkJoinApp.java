package no.computas.computasdag.old_futures;

import no.computas.computasdag.App;
import no.computas.computasdag.helper.MovieCharacter;
import no.computas.computasdag.helper.Quotes;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @Author: vda
 */
public class ForkJoinApp extends App {
    public static final MovieCharacter[] WRONG_CHARACTERS = {
            new MovieCharacter("Dr. Emmett Brown", "den svenske kongen"),
            new MovieCharacter("Marty McFly", "Thor Heyerdahl"),
            new MovieCharacter("George McFly", "Jens Stoltenberg"),
            new MovieCharacter("Lorraine Baines", "Erna Solberg"),
            new MovieCharacter("Lou", "Petter Northug")
    };

    public ForkJoinApp() {
        ForkJoinTask<List<MovieCharacter>> characters = getCharacters();
        String quote = Quotes.getRandomQuote();
        System.out.println(combine(characters.join(), quote));
        characters.complete(Arrays.asList(WRONG_CHARACTERS));
        System.out.println(combine(characters.join(), quote));

    }

    /**
     * With lambda shorthand
     */
    private ForkJoinTask<List<MovieCharacter>> getCharacters() {
        return ForkJoinPool.commonPool().submit(
                (Callable) () -> characterService.getCharacters());
    }

    public static void main(String[] args) {
        new ForkJoinApp();
    }
}
