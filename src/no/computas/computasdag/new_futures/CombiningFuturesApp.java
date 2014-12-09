package no.computas.computasdag.new_futures;

import no.computas.computasdag.App;
import no.computas.computasdag.helper.MovieCharacter;
import no.computas.computasdag.helper.Quotes;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CombiningFuturesApp extends App {
    public CombiningFuturesApp() {
        CompletableFuture<List<MovieCharacter>> characters = CompletableFuture.supplyAsync(
                () -> characterService.getCharacters());
        CompletableFuture<String> quote = CompletableFuture.supplyAsync(
                () -> Quotes.getRandomQuote());
        characters.thenAcceptBoth(quote,
                (chars, q) -> System.out.println(combine(chars, q))).join();
    }

    public static void main(String[] args) {
        new CombiningFuturesApp();
    }
}
