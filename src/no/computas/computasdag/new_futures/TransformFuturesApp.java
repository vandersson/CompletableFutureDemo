package no.computas.computasdag.new_futures;

import no.computas.computasdag.App;
import no.computas.computasdag.helper.MovieCharacter;
import no.computas.computasdag.helper.Quotes;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TransformFuturesApp extends App {
    public TransformFuturesApp() {
        CompletableFuture<List<MovieCharacter>> characters = CompletableFuture.supplyAsync(
                () -> characterService.getCharacters());
        CompletableFuture<String> quote = CompletableFuture.supplyAsync(
                () -> Quotes.getRandomQuote());

        System.out.println(
            characters
                    .thenCombine(quote, (c, q) -> combine(c, q))
                    .join());

    }

    public static void main(String[] args) {
        new TransformFuturesApp();
    }
}
