package no.computas.computasdag.new_futures;

import no.computas.computasdag.App;
import no.computas.computasdag.helper.MovieCharacter;
import no.computas.computasdag.helper.Quotes;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompleteExceptionallyApp extends App {
    public CompleteExceptionallyApp() {
        CompletableFuture<List<MovieCharacter>> characters = CompletableFuture.supplyAsync(
                () -> getMovieCharacters());
        String quote = Quotes.getRandomQuote();
//        characters.completeExceptionally(new UnsupportedOperationException("Not yet implemented"));
        try {
            characters.thenAccept((c) -> System.out.println(combine(c, quote))).get(2l, TimeUnit.SECONDS);
            //Get => checked exception
            //join => unchecked exception
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } catch (TimeoutException te) {
            te.printStackTrace();
        } catch (ExecutionException ei) {
            ei.printStackTrace();
        }
    }

    private List<MovieCharacter> getMovieCharacters() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        throw new NullPointerException("Something is null");
    }

    public static void main(String[] args) {
        new CompleteExceptionallyApp();
    }
}
