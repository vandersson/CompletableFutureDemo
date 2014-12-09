package no.computas.computasdag.old_futures;

import no.computas.computasdag.App;
import no.computas.computasdag.helper.MovieCharacter;
import no.computas.computasdag.helper.Quotes;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureApp extends App {
    private final ExecutorService pool = Executors.newFixedThreadPool(5);

    public FutureApp() {
        try {
            Future<List<MovieCharacter>> characters = getCharacters();
            String quote = Quotes.getRandomQuote();
            System.out.println(combine(characters.get(), quote));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Plain old java way
     */
    private Future<List<MovieCharacter>> getCharacters() {
        return pool.submit(new Callable<List<MovieCharacter>>() {
            @Override
            public List<MovieCharacter> call() throws Exception {
                return characterService.getCharacters();
            }
        });
    }

    public static void main(String[] args) {
        new FutureApp();
    }
}
