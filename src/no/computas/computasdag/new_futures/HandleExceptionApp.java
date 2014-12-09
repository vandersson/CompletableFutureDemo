package no.computas.computasdag.new_futures;

import no.computas.computasdag.App;
import no.computas.computasdag.helper.MovieCharacter;
import no.computas.computasdag.helper.Quotes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @Author: vda
 */
public class HandleExceptionApp extends App {

    public HandleExceptionApp() {
        CompletableFuture<List<MovieCharacter>> characters = CompletableFuture.supplyAsync(
                () -> getMovieCharacters());
        String quote = Quotes.getRandomQuote();

        characters
                .exceptionally((e) -> {
                    System.err.println(String.format("Got exception: %s", e.getMessage()));
                    return new ArrayList<MovieCharacter>();
                })
                .thenAccept(
                        (c) -> System.out.println(combine(c, quote)))
                .join();

    }

    private List<MovieCharacter> getMovieCharacters() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        throw new NullPointerException("Something is null");
    }

    public static void main(String[] args) {
        new HandleExceptionApp();
    }
}
