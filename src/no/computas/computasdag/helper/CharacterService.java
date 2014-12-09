package no.computas.computasdag.helper;

import java.util.Arrays;
import java.util.List;

public class CharacterService {
    public static final MovieCharacter[] CHARACTERS = {
            new MovieCharacter("Dr. Emmett Brown", "Christopher Lloyd"),
            new MovieCharacter("Marty McFly", "Michael J. Fox"),
            new MovieCharacter("George McFly", "Crispin Glover"),
            new MovieCharacter("Lorraine Baines", "Lea Thompson"),
            new MovieCharacter("Lou", "Norman Alden")
    };

    public List<MovieCharacter> getCharacters() {
        System.out.println("getting characters");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        System.out.println("returning characters");
        return getCharacterList();
    }

    protected List<MovieCharacter> getCharacterList() {
        return Arrays.asList(CHARACTERS);
    }
}
