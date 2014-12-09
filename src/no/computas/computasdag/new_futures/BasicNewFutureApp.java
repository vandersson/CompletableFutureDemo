package no.computas.computasdag.new_futures;

import no.computas.computasdag.App;
import no.computas.computasdag.helper.MovieCharacter;
import no.computas.computasdag.helper.Quotes;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @Author: vda
 */
public class BasicNewFutureApp extends App {
    public BasicNewFutureApp() {
        CompletableFuture<List<MovieCharacter>> characters = CompletableFuture.supplyAsync(
                () -> characterService.getCharacters());
        String quote = Quotes.getRandomQuote();
        System.out.println(combine(characters.join(), quote));
//        characters.complete(Arrays.asList(ForkJoinApp.WRONG_CHARACTERS));
//        System.out.println(combine(characters.join(), quote));
    }

    public static void main(String[] args) {
        new BasicNewFutureApp();
    }
}
