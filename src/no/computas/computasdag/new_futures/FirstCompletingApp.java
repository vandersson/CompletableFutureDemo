package no.computas.computasdag.new_futures;

import no.computas.computasdag.App;
import no.computas.computasdag.helper.MovieCharacter;
import no.computas.computasdag.helper.Quotes;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class FirstCompletingApp extends App {
    private static final MovieCharacter[] LOCAL_CHARACTERS = {
            new MovieCharacter("Dr. Emmett Brown", "Dr. Emmett Brown"),
            new MovieCharacter("Marty McFly", "Marty McFly"),
            new MovieCharacter("George McFly", "George McFly"),
            new MovieCharacter("Lorraine Baines", "Lorraine Baines"),
            new MovieCharacter("Lou", "Lou")

    };

    public FirstCompletingApp() {
        String quote = Quotes.getRandomQuote();
        CompletableFuture<List<MovieCharacter>> characters = CompletableFuture.supplyAsync(
                () -> characterService.getCharacters());
        CompletableFuture<List<MovieCharacter>> fastCharacters = CompletableFuture.supplyAsync(
                () -> getLocalCharacters());
        characters.acceptEither(fastCharacters,
                (c) -> System.out.println(combine(c, quote))).join();

    }

    private List<MovieCharacter> getLocalCharacters() {
//        try { Thread.sleep(3000); } catch (Exception e) {}
        return Arrays.asList(LOCAL_CHARACTERS);
    }

    public static void main(String[] args) {
        new FirstCompletingApp();
    }

}
