package no.computas.computasdag.new_futures;

import no.computas.computasdag.App;
import no.computas.computasdag.helper.MovieCharacter;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @Author: vda
 */
public class ChainingFuturesApp extends App {

    public ChainingFuturesApp() {
        CompletableFuture<List<MovieCharacter>> characters = CompletableFuture.supplyAsync(
                () -> characterService.getCharacters());
        characters.thenCompose(this::getActors)
                .thenAccept((a) -> System.out.println(String.format("List of actors: %s", a.toString())))
                .join();
    }

    private CompletableFuture<List<String>> getActors(List<MovieCharacter> movieCharacters) {
        return CompletableFuture.supplyAsync(
                () -> movieCharacters
                        .stream()
                        .map((c) -> c.getActor())
                        .collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        new ChainingFuturesApp();
    }
}
